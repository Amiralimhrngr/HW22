package model;

import jakarta.persistence.*;
import model.basemodel.BaseModel;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author extends BaseModel<Long> {
    @Column(nullable = false)
    private String name;
    @Column(name = "birth_date")
    private String birthDate;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id", nullable = false, unique = true)
    private Profile profile;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String name, String birthDate, Profile profile, Set<Book> books) {
        this.name = name;
        this.birthDate = birthDate;
        this.profile = profile;
        this.books = books;
    }

    public Author(Long aLong, String name, String birthDate, Profile profile, Set<Book> books) {
        super(aLong);
        this.name = name;
        this.birthDate = birthDate;
        this.profile = profile;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(birthDate, author.birthDate) && Objects.equals(profile, author.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, profile);
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.getAuthors().add(this);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", profile=" + profile +
                '}';
    }
}
