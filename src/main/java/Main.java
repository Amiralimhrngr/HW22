import model.*;
import factory.RepositoryFactory;
import model.builder.AuthorBuilder;
import model.builder.BookBuilder;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.CategoryRepository;
import service.AuthorService;
import service.BookService;
import service.CategoryService;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;


public class Main {
    public static void main(String[] args) {
        RepositoryFactory factory = RepositoryFactory.getInstance();
        BookRepository bookRepository = (BookRepository) factory.createBookRepository();
        AuthorRepository authorRepository = (AuthorRepository) factory.createAuthorRepository();
        CategoryRepository categoryRepository = (CategoryRepository) factory.createCategoryRepository();

        BookService bookService = new BookServiceImpl(bookRepository);
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        CategoryService categoryService = new CategoryServiceImpl(categoryRepository);


        Author author1 = new AuthorBuilder().setName("George Orwell").setBirthDate("1903").buildAuthor();
        author1.setProfile(new Profile("English novelist and essayist.", "https://orwell.example", author1));
        Author author2 = new AuthorBuilder().setName("J. R. R. Tolkien").setBirthDate("1892").buildAuthor();
        author2.setProfile(new Profile("English writer and philologist.", "https://tolkien.example", author2));
        Author author3 = new AuthorBuilder().setName("Frank Herbert").setBirthDate("1920").buildAuthor();
        author3.setProfile(new Profile("American science fiction author.", "https://herbert.example", author3));

        authorService.create(author1);
        authorService.create(author2);
        authorService.create(author3);

        Category fiction = new Category("Classic Fiction");
        Category fantasy = new Category("Fantasy");
        Category scienceFiction = new Category("Science Fiction");

        Book book1 = new BookBuilder()
                .setTitle("1984")
                .setIsbn("9780000000001")
                .setPublicationYear(1949)
                .setPrice(18.90)
                .setStockStatus(StockStatus.IN_STOCK)
                .setPublisherAddress(new PublisherAddress("London", "George St", "SW1A 1AA"))
                .setAuthor(author1)
                .setCategory(fiction)
                .buildBook();

        Book book2 = new BookBuilder()
                .setTitle("The Hobbit")
                .setIsbn("9780000000002")
                .setPublicationYear(1937)
                .setPrice(22.50)
                .setStockStatus(StockStatus.IN_STOCK)
                .setPublisherAddress(new PublisherAddress("London", "Fantasy Rd", "SW1A 2BB"))
                .setAuthor(author2)
                .setCategory(fantasy)
                .buildBook();

        Book book3 = new BookBuilder()
                .setTitle("Dune")
                .setIsbn("9780000000003")
                .setPublicationYear(1965)
                .setPrice(27.75)
                .setStockStatus(StockStatus.COMING_SOON)
                .setPublisherAddress(new PublisherAddress("New York", "Sci-Fi Ave", "10001"))
                .setAuthor(author3)
                .setCategory(scienceFiction)
                .buildBook();

        fiction.addBook(book1);
        fantasy.addBook(book2);
        scienceFiction.addBook(book3);

        categoryService.create(fiction);
        categoryService.create(fantasy);
        categoryService.create(scienceFiction);

        Long retrievedId = book1.getId();
        Book retrieved = bookService.read(retrievedId);
        System.out.println("Retrieved: " + retrieved);

        retrieved.setPrice(19.99);
        retrieved.setStockStatus(StockStatus.OUT_OF_STOCK);
        bookRepository.update(retrievedId, retrieved);

        bookRepository.delete(book2.getId());

        System.out.println("\n=== FINAL BOOK STATE ===");
        bookRepository.findAll().forEach(System.out::println);

        System.out.println("\n=== FINAL AUTHOR STATE ===");
        authorRepository.findAll().forEach(System.out::println);

    }
}
