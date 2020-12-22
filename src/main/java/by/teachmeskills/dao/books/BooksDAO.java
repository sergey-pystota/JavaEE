package by.teachmeskills.dao.books;
import by.teachmeskills.dao.DAO;
import by.teachmeskills.module.book.BookEntity;

public interface BooksDAO extends DAO<BookEntity> {
    BookEntity getByTitle(String title);
    BookEntity getByAuthor(String title);

}
