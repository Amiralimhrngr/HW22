package factory;

import repository.AuthorRepository;
import repository.BookRepository;
import repository.CategoryRepository;
import repository.ProfileRepository;
import repository.impl.AuthorRepositoryImpl;
import repository.impl.BookRepositoryImpl;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.ProfileRepositoryImpl;

public final class DefaultRepositoryFactory extends RepositoryFactory {
    @Override
    public BookRepository createBookRepository() {
        return new BookRepositoryImpl();
    }

    @Override
    public AuthorRepository createAuthorRepository() {
        return new AuthorRepositoryImpl();
    }

    @Override
    public ProfileRepository createProfileRepository() {
        return new ProfileRepositoryImpl();
    }

    @Override
    public CategoryRepository createCategoryRepository() {
        return new CategoryRepositoryImpl();
    }
}
