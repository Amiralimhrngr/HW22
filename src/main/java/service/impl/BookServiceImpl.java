package service.impl;

import model.Book;
import repository.BookRepository;
import service.BookService;

public class BookServiceImpl extends BaseServiceImpl<Book, Long, BookRepository> implements BookService {
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }

    @Override
    public void validation(Book book) {
        if (book != null) {
            if (book.getTitle() == null || book.getTitle().isBlank()) {
                throw new IllegalArgumentException("Title can not be null or empty!");
            }
            if (book.getPrice() == null || book.getPrice() <= 0) {
                throw new IllegalArgumentException("Price can not be null or negative!");
            }
            if (book.getIsbn() == null || book.getIsbn().isBlank()) {
                throw new IllegalArgumentException("ISBN can not be null or empty!");
            }
            if (book.getAuthors() == null) {
                throw new IllegalArgumentException("Authors can not be null!");
            }
            if (book.getStockStatus() == null) {
                throw new IllegalArgumentException("Stock status can not be null!");
            }
            if (book.getPublisherAddress() == null) {
                throw new IllegalArgumentException("Publisher Address can not be null!");
            }
            if (book.getPublisherAddress().getPostalCode() == null || book.getPublisherAddress().getPostalCode().isBlank()) {
                throw new IllegalArgumentException("Postal code can not be null or empty!");
            }
        } else {
            throw new IllegalArgumentException("New book can not be null!");
        }
    }
}
