package org.blah.dao;

import org.blah.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adam on 24.08.16.
 */
@Repository
public class DAO {

    @PersistenceContext
    private EntityManager em;

    public User saveUser(User user) {
        em.persist(user);
        return user;
    }

    public User getUserById(Long userId) {
        return em.find(User.class, userId);
    }

    public List<User> getUsers() {
        Query query = em.createQuery("SELECT user FROM User user");
        return (List<User>) query.getResultList();
    }

    public void remove(User user) {
        em.remove(user);
    }

    public User updateUser(User user) {
        return em.merge(user);
    }
}
