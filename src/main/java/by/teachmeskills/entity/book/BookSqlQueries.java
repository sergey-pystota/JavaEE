package by.teachmeskills.entity.book;

public class BookSqlQueries {
    public static final String INSERT_BOOK = "INSERT  INTO books (title,author,description,year,price) VALUES(?,?,?,?,?);";
    public static final String GET_ALL_BOOKS = "SELECT * FROM books";
    public static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    public static final String UPDATE_BOOK = "UPDATE books SET price = ?, title = ?, author = ?, year = ?, description = ? WHERE id = ? ";
    public static final String GET_BOOK = "SELECT * FROM books  WHERE id = ? ";

}

