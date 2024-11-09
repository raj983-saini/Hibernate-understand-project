package org.example.Service;

import org.example.Dao.ProductDAO;
import org.example.Entity.Product;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService(SessionFactory sessionFactory) {
        this.productDAO = new ProductDAO(sessionFactory);
    }

    // Save a product
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    // Update a product
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return productDAO.findById(id);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    // Delete a product
    public void deleteProduct(Product product) {
        productDAO.delete(product);
    }

    // Find products by category ID
    public List<Product> getProductsByCategory(Long categoryId) {
        return productDAO.findByCategory(categoryId);
    }

    // Find products by color
    public List<Product> getProductsByColor(String color) {
        return productDAO.findByColor(color);
    }
}
