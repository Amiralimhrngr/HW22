package repository.impl;

import model.Author;
import model.Book;
import repository.AuthorRepository;

import java.util.HashSet;
import java.util.Set;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Long> implements AuthorRepository {
    @Override
    public Class<Author> getEntityClass() {
        return Author.class;
    }

    @Override
    public void settingAttributes(Author upgradingAuthor, Author newAuthor) {
        upgradingAuthor.setName(newAuthor.getName());
        upgradingAuthor.setBirthDate(newAuthor.getBirthDate());
        upgradingAuthor.setProfile(newAuthor.getProfile());
        Set<Book> books = new HashSet<>();
        for (Book book : newAuthor.getBooks()) {
            books.add(book);
        }
        upgradingAuthor.setBooks(books);
    }
}



