package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.CompanyEmployee;

import java.util.List;

public interface UserDAO {
    void insert(CompanyEmployee companyEmployee);
    CompanyEmployee getById(int id);
    void update(CompanyEmployee companyEmployee);
    void deleteById(int id);
    List<CompanyEmployee> getAll();
}
