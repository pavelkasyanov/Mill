package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.Mill;

import java.util.List;

public interface MillDAO {
    void insert(Mill mill);
    Mill getById(int id);
    void update(Mill mill);
    void deleteById(int id);
    List<Mill> getAll();

    List<Mill> sortByManufactureDate(int beginManufacture, int endManufacture);
}
