package service.impl;

import model.Author;
import repository.AuthorRepository;
import service.AuthorService;

public class AuthorServiceImpl extends BaseServiceImpl<Author, Long, AuthorRepository> implements AuthorService {

    public AuthorServiceImpl(AuthorRepository repository) {
        super(repository);
    }

    @Override
    public void validation(Author author) {
        if (author != null) {
            if (author.getName() == null || author.getName().isBlank()){
                throw new IllegalArgumentException("Name can not be null or empty!");
            }
            if (author.getProfile() == null) {
                throw new IllegalArgumentException("Profile can not be null!");
            }
        } else {
            throw new IllegalArgumentException("Author can not be null!");
        }
    }
}
