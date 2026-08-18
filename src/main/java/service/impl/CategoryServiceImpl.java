package service.impl;

import model.Category;
import repository.CategoryRepository;
import service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public void validation(Category category) {
        if (category.getName() == null || category.getName().isBlank()) {
            throw new IllegalArgumentException("Name can not be null or empty!");
        }
    }
}
