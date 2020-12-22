package by.teachmeskills.dao;

import by.teachmeskills.dao.exceptions.DAOException;
import by.teachmeskills.module.IEntity;


import java.sql.SQLException;
import java.util.List;

public interface DAO<T extends IEntity> {
    T create(T entity) throws DAOException, SQLException;

    T updateEntity(T entity) throws DAOException;

    void deleteEntity(Long id) throws DAOException;

    List<T> getAll() throws DAOException;
}
