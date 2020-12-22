package by.teachmeskills.service.impl;

import by.teachmeskills.converter.IConverter;
import by.teachmeskills.converter.product.BookConverter;
import by.teachmeskills.dao.exceptions.DAOException;
import by.teachmeskills.dao.impl.mysql.books.MySQLBooksDAO;
import by.teachmeskills.module.book.BookEntity;
import by.teachmeskills.service.dto.BookDTO;
import by.teachmeskills.service.dto.BookDTOService;

import java.sql.SQLException;
import java.util.List;

public class BookServiceDTO implements BookDTOService {
    private MySQLBooksDAO dto = MySQLBooksDAO.getInstance();
    private IConverter<BookEntity, BookDTO> converter = new BookConverter();

    @Override
    public List<BookDTO> getAllBooks() {
        return converter.convertAll(dto.getAll());

    }

}
