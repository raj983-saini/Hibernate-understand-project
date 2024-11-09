package org.example.Service;

import org.example.Dao.CategoryDAO;
import org.example.Entity.Category;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    // Add a new category
    public void addCategory(Category category) {
        categoryDAO.save(category);
    }

    // Find all categories
    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    // Update a category
    public void updateCategory(Category category) {
        categoryDAO.update(category);
    }

    // Delete a category
    public void deleteCategory(Long categoryId) {
        Category category = categoryDAO.findById(categoryId);
        if (category != null) {
            categoryDAO.delete(category);
        }
    }
}
