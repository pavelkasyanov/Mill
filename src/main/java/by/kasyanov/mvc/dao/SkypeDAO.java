package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.Skype;

import java.util.List;

public interface SkypeDAO {
    void insert(Skype skype);
    Skype getById(int id);
    void update(Skype skype);
    void deleteById(int id);
    List<Skype> getAll();
}
