package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.ToolShoopType;

import java.util.List;

public interface ToolShoopTypeDAO {
    void insert(ToolShoopType user);
    ToolShoopType getById(int id);
    ToolShoopType getByName(String name);
    void update(ToolShoopType user);
    void deleteById(int id);
    List<ToolShoopType> getAll();
}
