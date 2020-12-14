package by.teachmeskills.repository;

import by.teachmeskills.data.DBUtil;
import by.teachmeskills.module.User;
import by.teachmeskills.module.UserEntityFields;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InDataUserRepository {

    private InDataUserRepository() {
    }

    public static class InDataUserRepositoryHolder {
        public static final InDataUserRepository HOLDER_INSTANCE = new InDataUserRepository();
    }

    public static InDataUserRepository getInstance() {
        return InDataUserRepositoryHolder.HOLDER_INSTANCE;
    }

    private static final List<User> users = new ArrayList<>();


    public List<User> getAll() {
        try (Connection connection = DBUtil.getConnection();
             Statement preparedStatement = connection.createStatement()) {
            ResultSet rs = preparedStatement.executeQuery(UserEntityFields.getGetAllUsers());
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
//        user.setId(idGenerator.getAndIncrement());
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UserEntityFields.getInsertUser())) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}

