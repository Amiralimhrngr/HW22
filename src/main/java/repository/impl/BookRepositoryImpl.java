package repository.impl;

import model.Book;
import repository.BookRepository;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Long> implements BookRepository {
    @Override
    public Class<Book> getEntityClass() {
        return Book.class;
    }

    @Override
    public void settingAttributes(Book upgradingBook, Book newBook) {
        upgradingBook.setTitle(newBook.getTitle());
        upgradingBook.setPrice(newBook.getPrice());
        upgradingBook.setIsbn(newBook.getIsbn());
//        Set<Author> newAuthors = new HashSet<>();
//        for (Author author : newBook.getAuthors()) {
//
//        }
//        upgradingBook.setAuthors(new HashSet<>(newBook.getAuthors()));

    }
}
