package by.teachmeskills.entity.orderproducts;

import by.teachmeskills.entity.Entity;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "orders_books")
public class OrderBooksEntity extends Entity {
    @Column(name = "books_id_fk")
    private Long booksId;
    @Column(name = "orders_id_fk")
    private Long orderId;

    public OrderBooksEntity() {
    }

    public Long getBooksId() {
        return booksId;
    }

    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
