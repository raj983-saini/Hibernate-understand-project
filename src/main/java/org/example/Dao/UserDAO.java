package org.example.Dao;

import org.example.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO {
    private GenericDAO<User> genericDAO;

    public UserDAO(SessionFactory sessionFactory) {
        this.genericDAO = new GenericDAO<>(sessionFactory, User.class);
    }

    public void save(User user) {
        genericDAO.save(user);
    }

    public void update(User user) {
        genericDAO.update(user);
    }

    public User findById(Long id) {
        return genericDAO.findById(id);
    }

    public List<User> findAll() {
        return genericDAO.findAll();
    }

    public void delete(User user) {
        genericDAO.delete(user);
    }

    public User findByEmail(String email) {
        SessionFactory sessionFactory = null;
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }
}
