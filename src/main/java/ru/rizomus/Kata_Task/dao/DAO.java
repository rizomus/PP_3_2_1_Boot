package ru.rizomus.Kata_Task.dao;


import ru.rizomus.Kata_Task.model.User;

import java.util.List;

public interface DAO {

    List<User> allUsers();

    User show(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
