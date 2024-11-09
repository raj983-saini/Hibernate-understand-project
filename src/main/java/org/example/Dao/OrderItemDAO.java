package org.example.Dao;
import org.example.Entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class OrderItemDAO {
    private GenericDAO<OrderItem> genericDAO;

    public OrderItemDAO(SessionFactory sessionFactory) {
        this.genericDAO = new GenericDAO<>(sessionFactory, OrderItem.class);
    }

    public void save(OrderItem orderItem) {
        genericDAO.save(orderItem);
    }

    public void update(OrderItem orderItem) {
        genericDAO.update(orderItem);
    }

    public OrderItem findById(Long id) {
        return genericDAO.findById(id);
    }

    public List<OrderItem> findAll() {
        return genericDAO.findAll();
    }

    public void delete(OrderItem orderItem) {
        genericDAO.delete(orderItem);
    }

    public List<OrderItem> findByOrder(Long orderId) {
        SessionFactory sessionFactory = null;
        try (Session session = sessionFactory.openSession()) {
            Query<OrderItem> query = session.createQuery("FROM OrderItem WHERE order.id = :orderId", OrderItem.class);
            query.setParameter("orderId", orderId);
            return query.list();
        }
    }
}
