package by.teachmeskills.dao;


import by.teachmeskills.module.IEntity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDAO<T extends IEntity> implements DAO<T> {
    protected static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);
}
