package org.example.util;

import org.example.Entity.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // A static variable to hold the SessionFactory
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Build the SessionFactory from the hibernate.cfg.xml file
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // This loads hibernate.cfg.xml from the classpath
                    .addAnnotatedClass(Category.class) // Add your annotated classes here
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(OrderItem.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (HibernateException ex) {
            // Handle HibernateException which is related to Hibernate-specific errors
            System.err.println("SessionFactory creation failed due to HibernateException: " + ex.getMessage());
            ex.printStackTrace(); // Print the stack trace for debugging purposes
            throw new ExceptionInInitializerError(ex); // Re-throw the exception
        } catch (Exception ex) {
            // Catch any other general exception and provide a message
            System.err.println("SessionFactory creation failed due to general exception: " + ex.getMessage());
            ex.printStackTrace(); // Print the stack trace for debugging purposes
            throw new ExceptionInInitializerError(ex); // Re-throw the exception
        }
    }

    // Method to return the SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Method to shutdown the SessionFactory
    public static void shutdown() {
        // Close caches and connection pools
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}