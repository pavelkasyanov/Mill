package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.Producer;

import java.util.List;

public interface ProducerDAO {
    void insert(Producer producer);
    Producer getById(int id);
    void update(Producer producer);
    void deleteById(int id);
    List<Producer> getAll();
}
