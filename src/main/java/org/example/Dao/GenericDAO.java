package org.example.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GenericDAO<T> {
    private static final Logger logger = LoggerFactory.getLogger(GenericDAO.class);
    private Class<T> entityClass;
    private SessionFactory sessionFactory;

    // Constructor to initialize session factory and entity class
    public GenericDAO(SessionFactory sessionFactory, Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }

    // Save entity to the database
    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Error saving entity: {}", entity, e);
        }
    }

    // Update entity in the database
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Error updating entity: {}", entity, e);
        }
    }

    // Find an entity by its ID
    public T findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entityClass, id);
        } catch (Exception e) {
            logger.error("Error finding entity with ID: {}", id, e);
            return null;
        }
    }

    // Find all entities
    public List<T> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
        } catch (Exception e) {
            logger.error("Error retrieving all entities of type: {}", entityClass.getName(), e);
            return null;
        }
    }

    // Delete an entity from the database
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Error deleting entity: {}", entity, e);
        }
    }

    // Find entities by a specific field (example: name, email)
    public List<T> findByField(String fieldName, Object value) {
        try (Session session = sessionFactory.openSession()) {
            Query<T> query = session.createQuery("FROM " + entityClass.getName() + " WHERE " + fieldName + " = :value", entityClass);
            query.setParameter("value", value);
            return query.list();
        } catch (Exception e) {
            logger.error("Error finding entities by field: {} with value: {}", fieldName, value, e);
            return null;
        }
    }
}
