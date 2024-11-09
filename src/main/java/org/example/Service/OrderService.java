package org.example.Service;


import org.example.Dao.OrderDAO;
import org.example.Dao.OrderItemDAO;
import org.example.Dao.ProductDAO;
import org.example.Entity.*;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService(SessionFactory sessionFactory) {
        this.orderDAO = new OrderDAO(sessionFactory);
    }

    // Save an order
    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    // Update an order
    public void updateOrder(Order order) {
        orderDAO.update(order);
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return orderDAO.findById(id);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderDAO.findAll();
    }

    // Delete an order
    public void deleteOrder(Order order) {
        orderDAO.delete(order);
    }

    // Get orders by user ID
    public List<Order> getOrdersByUser(Long userId) {
        return orderDAO.findByUser(userId);
    }
}
