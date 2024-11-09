package org.example.Service;

import org.example.Dao.UserDAO;
import org.example.Entity.User;
import org.hibernate.SessionFactory;

import java.util.List;
public class UserService {
    private UserDAO userDAO;

    public UserService(SessionFactory sessionFactory) {
        this.userDAO = new UserDAO(sessionFactory);
    }

    // Save a user
    public void saveUser(User user) {
        userDAO.save(user);
    }

    // Update a user
    public void updateUser(User user) {
        userDAO.update(user);
    }

    // Get user by ID
    public User getUserById(Long id) {
        return userDAO.findById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    // Delete a user
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    // Find user by email
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
