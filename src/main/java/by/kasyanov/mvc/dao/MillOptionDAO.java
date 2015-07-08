package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.model.MillOption;

import java.util.List;

public interface MillOptionDAO {
    void insert(MillOption millOption);
    MillOption getById(int id);
    void update(MillOption millOption);
    void deleteById(int id);
    List<MillOption> getAll();
}
