package by.teachmeskills.servlet;

import by.teachmeskills.DAOInitializer;
import by.teachmeskills.dao.impl.mysql.MySQLDAOInitializer;
import by.teachmeskills.dao.orm.init.OrmDAOInitializer;
import by.teachmeskills.entity.adress.AddressEntity;
import by.teachmeskills.entity.book.BookEntity;
import by.teachmeskills.entity.client.ClientEntity;
import by.teachmeskills.service.address.AddressService;
import by.teachmeskills.service.address.AddressServiceImpl;
import by.teachmeskills.service.client.ClientService;
import by.teachmeskills.service.client.ClientServiceImpl;
import by.teachmeskills.service.dto.BookDTO;
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
    private static final DAOInitializer ORM_DAO_INITIALIZER = new OrmDAOInitializer();


    private ClientService clientService = new ClientServiceImpl();
    private AddressService addressService = new AddressServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();
//        DAO_INITIALIZER.init();
        ORM_DAO_INITIALIZER.init();
        LOGGER.info("Bookshop servlet initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<BookDTO> userBooks = BooksServiceImpl.getInstance().getAllBooks();
        List<BookEntity> booksForAdmin = BooksServiceImpl.getInstance().getAll();
        final List<ClientEntity> clients = clientService.getAll();
        final List<AddressEntity> address = addressService.getALL();
        request.setAttribute("address", address);
        request.setAttribute("clients", clients);
        request.setAttribute("userbooks", userBooks);
        request.setAttribute("books", booksForAdmin);
        request.getRequestDispatcher("/bookshop.jsp").forward(request, response);
    }
}

