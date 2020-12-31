package by.teachmeskills.entity.order;

import by.teachmeskills.entity.Entity;
import by.teachmeskills.entity.book.BookEntity;
import by.teachmeskills.entity.client.ClientEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class OrderEntity extends Entity {
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id_fk", referencedColumnName = "id")
    private ClientEntity clientEntity;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_books", joinColumns = {
            @JoinColumn(name = "orders_id_fk", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "books_id_fk", referencedColumnName = "id")
    })
    private List<BookEntity> books;

    public OrderEntity() {
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<BookEntity> getBooks() {
        return new ArrayList<>(books);
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
