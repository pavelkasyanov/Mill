package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.model.User;

import java.util.List;

public interface UserDAO {
    void insert(User user);
    User getById(int id);
    void update(User user);
    void deleteById(int id);
    List<User> getAll();
}
