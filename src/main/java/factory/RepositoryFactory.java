package factory;

import model.*;
import repository.*;

public abstract class RepositoryFactory {
    private static final RepositoryFactory INSTANCE = new DefaultRepositoryFactory();

    public static RepositoryFactory getInstance() {
        return INSTANCE;
    }

    public abstract BaseRepository<Book, Long> createBookRepository();

    public abstract BaseRepository<Author, Long> createAuthorRepository();

    public abstract BaseRepository<Profile, Long> createProfileRepository();

    public abstract BaseRepository<Category, Long> createCategoryRepository();

}
