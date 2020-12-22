package by.teachmeskills.dao.impl.mysql;

import by.teachmeskills.DAOInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MySQLDAOInitializer implements DAOInitializer {

    private static final Logger LOGGER = LogManager.getLogger(MySQLDAOInitializer.class);
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private volatile boolean isInit;

    @Override
    public void init() {
        if (!isInit) {
            try {
                Class.forName(DRIVER);
                isInit = true;
                LOGGER.info("DAO initialized");
            } catch (ClassNotFoundException e) {
                LOGGER.error("Unable to load JDBC driver: " + e.getMessage());
            }
        }
    }

}

