package by.teachmeskills.dao.impl.mysql;

import by.teachmeskills.dao.AbstractDAO;
import by.teachmeskills.module.IEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public abstract class MySQLAbstractDAO<T extends IEntity> extends AbstractDAO<T> {
    protected static final Logger LOGGER = LogManager.getLogger(MySQLAbstractDAO.class);
    private static final String DB_URL = "jdbc:mysql://localhost:3306/APP?serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1111";

    public Optional<Connection> getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            return Optional.of(connection);
        } catch (SQLException e) {
            LOGGER.error("Unable to get connection " + e.getMessage());

        }
        return Optional.empty();
    }
}
