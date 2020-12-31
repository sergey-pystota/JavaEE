package by.teachmeskills.entity.book;

import by.teachmeskills.entity.Entity;
import by.teachmeskills.entity.order.OrderEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class BookEntity extends Entity {

    private String title;
    private String author;
    private String description;
    @Column(name = "year")
    private int publishingYear;
    private double price;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_books", joinColumns = {
            @JoinColumn(name = "books_id_fk", referencedColumnName = "id")
    }, inverseJoinColumns = {
         @JoinColumn  (name = "orders_id_fk", referencedColumnName = "id")
    })
private List<OrderEntity> orders;

    public BookEntity() {
    }


    public BookEntity(Long id, String title, String author, String description, int publishingYear, double price) {
        super(id);
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishingYear = publishingYear;
        this.price = price;
    }
    public List<OrderEntity> getOrders() {
        return new ArrayList<>(orders);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}

