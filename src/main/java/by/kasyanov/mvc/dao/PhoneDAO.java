package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.model.Phone;

import java.util.List;

public interface PhoneDAO {
    void insert(Phone phone);
    Phone getById(int id);
    void update(Phone phone);
    void deleteById(int id);
    List<Phone> getAll();
}
