package model;

import jakarta.persistence.*;
import model.basemodel.BaseModel;

import java.util.Objects;
import java.util.Set;

@Entity
public class Book extends BaseModel<Long> {
    @Column(nullable = false)
    private String title;
    @Column(unique = true, nullable = false)
    private String isbn;
    @Column(name = "publication_year")
    private Integer publicationYear;
    @Column(nullable = false)
    private Double price;
    @Enumerated(value = EnumType.STRING)
    private StockStatus stockStatus;
    @Embedded
    private PublisherAddress publisherAddress;
    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    @ManyToOne
    private Category category;

    public Book() {
    }

    public Book(String title, String isbn, Integer publicationYear, Double price, StockStatus stockStatus, PublisherAddress publisherAddress, Set<Author> authors, Category category) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stockStatus = stockStatus;
        this.publisherAddress = publisherAddress;
        this.authors = authors;
        this.category = category;
    }

    public Book(Long aLong, String title, String isbn, Integer publicationYear, Double price, StockStatus stockStatus, PublisherAddress publisherAddress, Set<Author> authors, Category category) {
        super(aLong);
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stockStatus = stockStatus;
        this.publisherAddress = publisherAddress;
        this.authors = authors;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public PublisherAddress getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(PublisherAddress publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", stockStatus=" + stockStatus +
                ", publisherAddress=" + publisherAddress +
                '}';
    }
}
