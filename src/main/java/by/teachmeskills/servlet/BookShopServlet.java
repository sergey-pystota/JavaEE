package by.teachmeskills.servlet;

import by.teachmeskills.DAOInitializer;
import by.teachmeskills.dao.impl.mysql.MySQLDAOInitializer;
import by.teachmeskills.module.book.BookEntity;
import by.teachmeskills.service.dto.BookDTO;
import by.teachmeskills.service.dto.BookDTOService;
import by.teachmeskills.service.impl.BookServiceDTO;
import by.teachmeskills.service.impl.BooksServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookshop")

public class BookShopServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(BookShopServlet.class);
    private static final DAOInitializer DAO_INITIALIZER = new MySQLDAOInitializer();

    private BookDTOService booksService = new BookServiceDTO();

    @Override
    public void init() throws ServletException {
        super.init();
        DAO_INITIALIZER.init();
        LOGGER.info("Bookshop servlet initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<BookDTO> userBooks = booksService.getAllBooks();
        List<BookEntity> booksForAdmin = BooksServiceImpl.getInstance().getAll();
        request.setAttribute("userbooks", userBooks);
        request.setAttribute("books", booksForAdmin);
        request.getRequestDispatcher("/bookshop.jsp").forward(request, response);
    }
}

