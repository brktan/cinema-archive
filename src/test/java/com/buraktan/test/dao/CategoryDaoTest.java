package com.buraktan.test.dao;

import com.buraktan.app.core.dao.CategoryDao;
import com.buraktan.app.core.domain.Category;
import org.junit.Test;

import java.util.List;

public class CategoryDaoTest {

    @Test
    public void findAllCategoriesTest() {

        List<Category> categoryList;
        CategoryDao categoryDao = new CategoryDao();
        categoryList = categoryDao.findAllCategories();

        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    @Test
    public void saveCategoryTest() {

        Category category = new Category();
        category.setName("Adventure");

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.saveCategory(category);
    }

    @Test
    public void deleteCategoryTest() {

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.deleteCategory(1L);

    }

    @Test
    public void findCategoryByIdTest() {

        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.findCategoryById(2L);
        System.out.println(category);
    }
}
