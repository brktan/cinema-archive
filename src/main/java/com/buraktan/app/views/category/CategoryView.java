package com.buraktan.app.views.category;

import com.buraktan.app.core.dao.CategoryDao;
import com.buraktan.app.core.domain.Category;
import com.buraktan.app.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.List;

@PageTitle("Category")
@Route(value = "category", layout = MainLayout.class)
@RouteAlias(value = "category", layout = MainLayout.class)
public class CategoryView extends VerticalLayout {

    CategoryDao categoryDao = new CategoryDao();
    public CategoryView() {
        addClassName("category");

        List<Category> categoryList;

        categoryList = categoryDao.findAllCategories();

        ListBox<Category> listbox = new ListBox<>();
        listbox.setItems(categoryList);


        Button addButton = new Button("Add Item", event -> {


            Category category = new Category();
            category.setName("Crime");
            CategoryDao categoryDao = new CategoryDao();
            categoryDao.saveCategory(category);

            ListBox<Category> listbox1 = new ListBox<>();
            List<Category> categoryList1;
            CategoryDao categoryDao2 = new CategoryDao();
            categoryList1 = categoryDao2.findAllCategories();
            listbox1.setItems(categoryList1);
            listbox1.getDataProvider().refreshAll();
            add(listbox1);
        });
        add(listbox);
        add(addButton);

    }
}
