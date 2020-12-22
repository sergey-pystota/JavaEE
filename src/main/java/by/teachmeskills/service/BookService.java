package by.teachmeskills.service;

import by.teachmeskills.dao.exceptions.DAOException;
import by.teachmeskills.service.dto.BookDTO;

import java.sql.SQLException;
import java.util.List;

public interface BookService<T> {

    T create(T entity) throws DAOException, SQLException;
    T updateEntity(T entity) throws DAOException;
    void deleteEntity(Long id) throws DAOException;
    List<T> getAll() throws DAOException;
}
