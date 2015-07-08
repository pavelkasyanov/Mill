package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.model.Mill;

import java.util.List;

public interface MillDAO {
    void insert(Mill mill);
    Mill getById(int id);
    void update(Mill mill);
    void deleteById(int id);
    List<Mill> getAll();
}
