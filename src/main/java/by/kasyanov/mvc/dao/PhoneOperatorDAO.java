package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.model.PhoneOperator;

import java.util.List;

public interface PhoneOperatorDAO {
    void insert(PhoneOperator phoneOperator);
    PhoneOperator getById(int id);
    void update(PhoneOperator phoneOperator);
    void deleteById(int id);
    List<PhoneOperator> getAll();
}
