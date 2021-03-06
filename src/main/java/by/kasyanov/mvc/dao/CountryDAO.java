package by.kasyanov.mvc.dao;


import by.kasyanov.mvc.entities.Country;

import java.util.List;

public interface CountryDAO {

    void insert(Country country);
    Country getById(int id);
    void update(Country country);
    void deleteById(int id);
    List<Country> getAll();

    Country getByName(String name);
}
