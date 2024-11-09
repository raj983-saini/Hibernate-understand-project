package org.example.Service;

import org.example.Dao.OrderItemDAO;
import org.example.Entity.OrderItem;
import org.hibernate.SessionFactory;

import java.util.List;
public class OrderItemService {
    private OrderItemDAO orderItemDAO;

    public OrderItemService(SessionFactory sessionFactory) {
        this.orderItemDAO = new OrderItemDAO(sessionFactory);
    }

    // Save an order item
    public void saveOrderItem(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }

    // Update an order item
    public void updateOrderItem(OrderItem orderItem) {
        orderItemDAO.update(orderItem);
    }

    // Get order item by ID
    public OrderItem getOrderItemById(Long id) {
        return orderItemDAO.findById(id);
    }

    // Get all order items
    public List<OrderItem> getAllOrderItems() {
        return orderItemDAO.findAll();
    }

    // Delete an order item
    public void deleteOrderItem(OrderItem orderItem) {
        orderItemDAO.delete(orderItem);
    }

    // Get order items by order ID
    public List<OrderItem> getOrderItemsByOrder(Long orderId) {
        return orderItemDAO.findByOrder(orderId);
    }
}
