package model.builder;

import jakarta.persistence.*;
import model.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BookBuilder {
    private String title;
    private String isbn;
    private Integer publicationYear;
    private Double price;
    private StockStatus stockStatus;
    private PublisherAddress publisherAddress;
    private Set<Author> authors = new HashSet<>();
    private Category category;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public BookBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public BookBuilder setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
        return this;
    }

    public BookBuilder setPublisherAddress(PublisherAddress publisherAddress) {
        this.publisherAddress = publisherAddress;
        return this;
    }

    public BookBuilder setAuthors(Set<Author> authors) {
        this.authors = authors;
        return this;
    }

    public BookBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }
    public BookBuilder setAuthor(Author author) {
        this.authors.add(author);
        return this;
    }

    public Book buildBook() {
        return new Book(title, isbn, publicationYear, price, stockStatus, publisherAddress, authors,category);
    }
}
