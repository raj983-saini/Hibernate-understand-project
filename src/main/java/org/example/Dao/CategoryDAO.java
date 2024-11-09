package org.example.Dao;

import org.example.Entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends GenericDAO<Category> {
    public CategoryDAO(SessionFactory sessionFactory, Class<Category> entityClass) {
        super(sessionFactory, entityClass);
    }
}
