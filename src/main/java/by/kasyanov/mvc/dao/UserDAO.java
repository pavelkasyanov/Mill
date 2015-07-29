package by.kasyanov.mvc.dao;


import by.kasyanov.mvc.entities.User;

import java.util.List;

public interface UserDAO {
    void insert(User companyEmployee);
    User getById(int id);
    User getByName(String name);
    void update(User companyEmployee);
    void deleteById(int id);
    List<User> getAll();
}
