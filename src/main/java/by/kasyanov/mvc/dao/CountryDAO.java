package by.kasyanov.mvc.dao;


import by.kasyanov.mvc.model.Country;

import java.util.List;

public interface CountryDAO {

    void insert(Country country);
    Country getById(int id);
    void update(Country country);
    void deleteById(int id);
    List<Country> getAll();
}
