package by.teachmeskills.service.impl;

import by.teachmeskills.converter.IConverter;
import by.teachmeskills.converter.product.BookConverter;
import by.teachmeskills.dao.books.BooksDAO;
import by.teachmeskills.dao.exceptions.DAOException;
import by.teachmeskills.dao.impl.mysql.books.MySQLBooksDAO;
import by.teachmeskills.module.book.BookEntity;
import by.teachmeskills.service.BookService;
import by.teachmeskills.service.dto.BookDTO;
import by.teachmeskills.service.dto.BookDTOService;

import java.sql.SQLException;
import java.util.List;

public class BooksServiceImpl implements BookService<BookEntity> {
    private BooksServiceImpl() {
    }


    public static class BooksServiceImplHolder {
        public static final BooksServiceImpl HOLDER_INSTANCE = new BooksServiceImpl();
    }


    public static BooksServiceImpl getInstance() {
        return BooksServiceImpl.BooksServiceImplHolder.HOLDER_INSTANCE;
    }

    MySQLBooksDAO dao = MySQLBooksDAO.getInstance();
    private IConverter<BookEntity, BookDTO> converter = new BookConverter();

    @Override
    public BookEntity create(BookEntity entity) throws DAOException, SQLException {
        return dao.create(entity);
    }


    @Override
    public BookEntity updateEntity(BookEntity entity) throws DAOException {
        return dao.updateEntity(entity);
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {
       dao.deleteEntity(id);
    }


    @Override
    public List<BookEntity> getAll() throws DAOException {
        return dao.getAll();
    }
    public List<BookDTO> getAllBooks() {
        return converter.convertAll(dao.getAll());
    }

}
