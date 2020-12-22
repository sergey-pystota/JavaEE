package by.teachmeskills.dao.impl.mysql.books;


import by.teachmeskills.dao.books.BooksDAO;
import by.teachmeskills.dao.exceptions.DAOException;
import by.teachmeskills.dao.impl.mysql.MySQLAbstractDAO;
import by.teachmeskills.module.book.BookEntity;
import by.teachmeskills.module.book.BookFields;
import by.teachmeskills.module.book.BookSqlQueries;
import by.teachmeskills.module.user.UserSqlQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySQLBooksDAO extends MySQLAbstractDAO<BookEntity> implements BooksDAO {
    private MySQLBooksDAO() {
    }

    public static class MySQLBooksDAOHolder {
        public static final MySQLBooksDAO HOLDER_INSTANCE = new MySQLBooksDAO();
    }

    public static MySQLBooksDAO getInstance() {
        return MySQLBooksDAO.MySQLBooksDAOHolder.HOLDER_INSTANCE;
    }

    @Override
    public BookEntity create(BookEntity entity) throws DAOException {
        final Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueries.INSERT_USER)) {
                preparedStatement.setString(1, entity.getTitle());
                preparedStatement.setString(2, entity.getAuthor());
                preparedStatement.setString(3, entity.getDescription());
                preparedStatement.setInt(4, entity.getPublishingYear());
                preparedStatement.setDouble(5, entity.getPrice());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: " + e.getMessage());
                throw new DAOException("Unable to create books");
            }

        }
        return entity;
    }

    @Override
    public BookEntity updateEntity(BookEntity entity) throws DAOException {
        final Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 PreparedStatement statement = connection.prepareStatement(BookSqlQueries.UPDATE_BOOK)) {
                statement.setDouble(1, entity.getPrice());
                statement.executeUpdate();

            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: " + e.getMessage());
                throw new DAOException("Unable to update books");
            }
        }
        return entity;
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {
        final Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 PreparedStatement statement = connection.prepareStatement(BookSqlQueries.DELETE_BOOK)) {
                statement.setLong(1, id);
                statement.execute();

            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: " + e.getMessage());
                throw new DAOException("Unable to delete books");
            }
        }
    }

    @Override
    public List<BookEntity> getAll() throws DAOException {
        final Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(BookSqlQueries.GET_ALL_BOOKS);
                List<BookEntity> productEntities = new ArrayList<>();
                while (resultSet.next()) {
                    final BookEntity productEntity = processResultSet(resultSet);
                    productEntities.add(productEntity);
                }
                return productEntities;
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: " + e.getMessage());
                throw new DAOException("Unable to retrieve products");

            }
        }
        return Collections.emptyList();

    }

    @Override
    public BookEntity getByTitle(String title) {
        return null;
    }

    @Override
    public BookEntity getByAuthor(String title) {
        return null;
    }

    private BookEntity processResultSet(ResultSet resultSet) {
        try {
            final long id = resultSet.getLong(BookFields.ID);
            final String title = resultSet.getString(BookFields.TITLE);
            final String author = resultSet.getString(BookFields.AUTHOR);
            final String description = resultSet.getString(BookFields.DESCRIPTION);
            final double price = resultSet.getDouble(BookFields.PRICE);
            final int year = resultSet.getInt(BookFields.YEAR);

            return new BookEntity(id, title, author, description, year, price);
        } catch (SQLException e) {
            LOGGER.error("Unable to parse ResultSet: " + e.getMessage());
            throw new DAOException("Unable to read book");
        }
    }
}
