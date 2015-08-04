package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.MillType;

import java.util.List;

public interface MillTypeDAO {

    void insert(MillType millOption);
    MillType getById(int id);
    MillType getByName(String name);
    void update(MillType millOption);
    void deleteById(int id);
    List<MillType> getAll();
}
