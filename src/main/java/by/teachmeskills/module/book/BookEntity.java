package by.teachmeskills.module.book;

import by.teachmeskills.module.Entity;

public class BookEntity extends Entity {
    private String title;
    private String author;
    private String description;
    private int publishingYear;
    private double price;

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

