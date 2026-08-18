package util;

import repository.AuthorRepository;
import repository.BookRepository;
import repository.CategoryRepository;
import repository.ProfileRepository;
import repository.impl.AuthorRepositoryImpl;
import repository.impl.BookRepositoryImpl;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.ProfileRepositoryImpl;
import service.AuthorService;
import service.BookService;
import service.CategoryService;
import service.ProfileService;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.ProfileServiceImpl;

public class ApplicationContext {
    private static final AuthorRepository AUTHOR_REPOSITORY;
    private static final AuthorService AUTHOR_SERVICE;
    private static final BookRepository BOOK_REPOSITORY;
    private static final BookService BOOK_SERVICE;
    private static final CategoryRepository CATEGORY_REPOSITORY;
    private static final CategoryService CATEGORY_SERVICE;
    private static final ProfileRepository PROFILE_REPOSITORY;
    private static final ProfileService PROFILE_SERVICE;

    static {
        AUTHOR_REPOSITORY = new AuthorRepositoryImpl();
        AUTHOR_SERVICE = new AuthorServiceImpl(AUTHOR_REPOSITORY);

        BOOK_REPOSITORY = new BookRepositoryImpl();
        BOOK_SERVICE = new BookServiceImpl(BOOK_REPOSITORY);

        CATEGORY_REPOSITORY = new CategoryRepositoryImpl();
        CATEGORY_SERVICE = new CategoryServiceImpl(CATEGORY_REPOSITORY);

        PROFILE_REPOSITORY = new ProfileRepositoryImpl();
        PROFILE_SERVICE = new ProfileServiceImpl(PROFILE_REPOSITORY);
    }

    public static AuthorService getAuthorService() {
        return AUTHOR_SERVICE;
    }

    public static BookService getBookService() {
        return BOOK_SERVICE;
    }

    public static CategoryService getCategoryService() {
        return CATEGORY_SERVICE;
    }

    public static ProfileService getProfileService() {
        return PROFILE_SERVICE;
    }
}
