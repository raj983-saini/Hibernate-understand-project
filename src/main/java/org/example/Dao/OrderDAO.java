package org.example.Dao;

import org.example.Entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDAO {
    private GenericDAO<Order> genericDAO;

    public OrderDAO(SessionFactory sessionFactory) {
        this.genericDAO = new GenericDAO<>(sessionFactory, Order.class);
    }

    public void save(Order order) {
        genericDAO.save(order);
    }

    public void update(Order order) {
        genericDAO.update(order);
    }

    public Order findById(Long id) {
        return genericDAO.findById(id);
    }

    public List<Order> findAll() {
        return genericDAO.findAll();
    }

    public void delete(Order order) {
        genericDAO.delete(order);
    }

    public List<Order> findByUser(Long userId) {
        SessionFactory sessionFactory = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("FROM Order WHERE user.id = :userId", Order.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

    public List<Order> findByStatus(String status) {
        SessionFactory sessionFactory = null;
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Order o WHERE o.status = :status", Order.class)
                          .setParameter("status", status)
                          .list();
        }
    }
}



