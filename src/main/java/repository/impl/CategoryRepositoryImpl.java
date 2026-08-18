package repository.impl;

import model.Category;
import repository.CategoryRepository;

public class CategoryRepositoryImpl extends BaseRepositoryImpl<Category, Long> implements CategoryRepository {
    @Override
    public Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    public void settingAttributes(Category upgradingEntity, Category newEntity) {

    }
}
