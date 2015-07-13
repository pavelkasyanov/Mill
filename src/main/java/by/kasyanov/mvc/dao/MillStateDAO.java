package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.MillState;

import java.util.List;

public interface MillStateDAO {
    void insert(MillState millState);
    MillState getById(int id);
    void update(MillState millState);
    void deleteById(int id);
    List<MillState> getAll();
}
