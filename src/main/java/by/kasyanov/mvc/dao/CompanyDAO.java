package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.model.Company;

import java.util.List;

public interface CompanyDAO {
    void insert(Company company);
    Company getById(int id);
    void update(Company company);
    void deleteById(int id);
    List<Company> getAll();
}
