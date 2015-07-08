package by.kasyanov.mvc.dao;


import by.kasyanov.mvc.model.Email;
import java.util.List;

public interface EmailDAO {
    void insert(Email email);
    Email getById(int id);
    void update(Email email);
    void deleteById(int id);
    List<Email> getAll();
}
