import model.*;
import factory.RepositoryFactory;
import model.builder.BookBuilder;
import repository.BookRepository;
import repository.CategoryRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class DigitalLibraryRepositoryTest {
    private static BookRepository bookRepository;
    private static CategoryRepository categoryRepository;

    @BeforeAll
    static void setup() {
        RepositoryFactory factory = RepositoryFactory.getInstance();
        bookRepository = (BookRepository) factory.createBookRepository();
        categoryRepository = (CategoryRepository) factory.createCategoryRepository();
    }

    @Test
    void testSaveAndFindBook() {
        Category category = new Category("Testing Category " + System.nanoTime());
        Book original = new BookBuilder()
                .setTitle("Test Driven Book")
                .setIsbn("ISBN-TEST-" + System.nanoTime())
                .setPublicationYear(2026)
                .setPrice(14.99)
                .setStockStatus(StockStatus.IN_STOCK)
                .setPublisherAddress(new PublisherAddress("Baku", "Nizami St", "AZ1000"))
                .setCategory(category)
                .buildBook();
        category.addBook(original);

        categoryRepository.create(category);

        Book retrieved = bookRepository.read(original.getId());
        assertNotNull(retrieved);
        assertEquals(original.getTitle(), retrieved.getTitle());
        assertEquals(original.getPublisherAddress(), retrieved.getPublisherAddress());
    }

    @Test
    void testCategoryCascadePersist() {
        Category category = new Category("Cascade Category " + System.nanoTime());

        Book book1 = new BookBuilder()
                .setTitle("Cascade Book One")
                .setIsbn("ISBN-CASCADE-1-" + System.nanoTime())
                .setPublicationYear(2025)
                .setPrice(10.00)
                .setStockStatus(StockStatus.IN_STOCK)
                .setPublisherAddress(new PublisherAddress("Baku", "1st St", "AZ1001"))
                .setCategory(category)
                .buildBook();

        Book book2 = new BookBuilder()
                .setTitle("Cascade Book Two")
                .setIsbn("ISBN-CASCADE-2-" + System.nanoTime())
                .setPublicationYear(2024)
                .setPrice(11.00)
                .setStockStatus(StockStatus.COMING_SOON)
                .setPublisherAddress(new PublisherAddress("Baku", "2nd St", "AZ1002"))
                .setCategory(category)
                .buildBook();

        category.addBook(book1);
        category.addBook(book2);

        categoryRepository.create(category);

        Category retrieved = categoryRepository.read(category.getId());
        assertNotNull(retrieved);
        assertEquals(2, retrieved.getBooks().size());

        assertTrue(retrieved.getBooks().stream().anyMatch(b -> b.getId().equals(book1.getId())));
        assertTrue(retrieved.getBooks().stream().anyMatch(b -> b.getId().equals(book2.getId())));
        assertNotNull(bookRepository.read(book1.getId()));
        assertNotNull(bookRepository.read(book2.getId()));
    }
}
