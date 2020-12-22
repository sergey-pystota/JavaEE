package by.teachmeskills.converter.product;

import by.teachmeskills.converter.AbstractConverter;
import by.teachmeskills.module.book.BookEntity;
import by.teachmeskills.service.dto.BookDTO;

public class BookConverter extends AbstractConverter<BookEntity, BookDTO> {
    private double newPrice;

    @Override
    public BookDTO convert(BookEntity entity) {
        newPrice = entity.getPrice() + entity.getPrice() * 0.2;

        return new BookDTO(entity.getTitle(), entity.getAuthor(), entity.getDescription(), newPrice);
    }
}
