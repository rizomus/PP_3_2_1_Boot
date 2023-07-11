package ru.rizomus.Kata_Task.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.rizomus.Kata_Task.model.User;

import java.util.List;

@Repository
public class UserDao implements DAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> allUsers() {

        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {

        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {

        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {

        entityManager.remove(show(id));
    }
}