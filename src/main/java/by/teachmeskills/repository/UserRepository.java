package by.teachmeskills.repository;

import by.teachmeskills.data.DBUtil;
import by.teachmeskills.module.User;
import by.teachmeskills.module.UserSqlQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserRepository {

    private UserRepository() {
    }

    public static class UserRepositoryHolder {
        public static final UserRepository HOLDER_INSTANCE = new UserRepository();
    }

    public static UserRepository getInstance() {
        return UserRepositoryHolder.HOLDER_INSTANCE;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             Statement preparedStatement = connection.createStatement()) {
            ResultSet rs = preparedStatement.executeQuery(UserSqlQueries.GET_ALL_USERS);
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("Surname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                users.add(new User(id, name, surname, email, password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public Optional<User> getById(long userId) {
        return Optional.empty();
    }

    public User save(User user) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueries.INSERT_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}

