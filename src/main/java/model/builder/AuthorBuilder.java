package model.builder;


import model.Author;
import model.Book;
import model.Profile;

import java.util.HashSet;
import java.util.Set;

public class AuthorBuilder {
    private String name;
    private String birthDate;
    private Profile profile;
    private Set<Book> books = new HashSet<>();

    public AuthorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public AuthorBuilder setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    public AuthorBuilder setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }

    public Author buildAuthor() {
        return new Author(name, birthDate, profile, books);
    }
}
