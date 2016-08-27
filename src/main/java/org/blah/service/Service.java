package org.blah.service;

import org.blah.dao.DAO;
import org.blah.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adam on 24.08.16.
 */
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private DAO dao;

    //show users
    @Transactional
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    @Transactional
    public List<User> getUsers() {
        return dao.getUsers();
    }

    //remove users
    @Transactional
    public void deleteUser(Long userId) {
        User user = dao.getUserById(userId);
        if (user == null) return;
        dao.remove(user);
    }

    @Transactional
    public void deleteUser(User user) {
        dao.remove(user);
    }

    //save users
    @Transactional
    public User saveUser(User user) {
        return dao.saveUser(user);
    }

    @Transactional
    public User updateUser(User user) {
        return dao.updateUser(user);
    }
}
