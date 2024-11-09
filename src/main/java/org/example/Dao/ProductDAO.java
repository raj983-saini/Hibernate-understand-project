package org.example.Dao;

import org.example.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO {
    private GenericDAO<Product> genericDAO;

    public ProductDAO(SessionFactory sessionFactory) {
        this.genericDAO = new GenericDAO<>(sessionFactory, Product.class);
    }

    public void save(Product product) {
        genericDAO.save(product);
    }

    public void update(Product product) {
        genericDAO.update(product);
    }

    public Product findById(Long id) {
        return genericDAO.findById(id);
    }

    public List<Product> findAll() {
        return genericDAO.findAll();
    }

    public void delete(Product product) {
        genericDAO.delete(product);
    }

    public List<Product> findByCategory(Long categoryId) {
        SessionFactory sessionFactory = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product WHERE category.id = :categoryId", Product.class);
            query.setParameter("categoryId", categoryId);
            return query.list();
        }
    }

    public List<Product> findByColor(String color) {
        SessionFactory sessionFactory = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product WHERE color = :color", Product.class);
            query.setParameter("color", color);
            return query.list();
        }
    }
}
