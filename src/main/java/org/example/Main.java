package org.example;

import org.example.Entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//
//        // Create and save Category
        Category category = new Category();
        category.setName("Electronics");

        session.save(category);
//
//        // Create and save Product
        Product product = new Product();
        product.setName("Smartphone");
        product.setDescription("Latest Android smartphone");
        product.setPrice(699.99);
        product.setSizes(Collections.singleton("LARGE"));
        product.setColors(Collections.singleton("RED"));
        product.setCategories(Collections.singleton(category));

        session.save(product);

//        // Create and save User
        User user = new User();
        user.setName("john_doe");
        user.setPassword("password123");
        user.setEmail("john.doe@example.com");
        user.setRoles(Collections.singleton("USER"));
        session.save(user);
//

//
//        // Create and save OrderItem
//        // Create and save Order
        Order order = new Order();
        OrderItem orderItem = new OrderItem();

        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(1);
        orderItem.setPrice(699.99);

        session.save(orderItem);

        order.setUser(user);
        order.setOrderDate(new Date());
        order.setStatus("Pending");
        order.setItems(Collections.singletonList(orderItem));

        session.save(order);
//        // Commit the transaction
        session.getTransaction().commit();
//
//        // Close the session
        session.close();
    }


}