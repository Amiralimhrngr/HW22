package service;

import model.Book;
import repository.BookRepository;

public interface BookService extends BaseService<Book, Long, BookRepository> {
}
