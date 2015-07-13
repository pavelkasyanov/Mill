package by.kasyanov.mvc.services;

import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.Producer;

import java.util.List;

public interface MillService {
    void insert(Mill mill);
    Mill getById(int id);
    void update(Mill mill);
    void deleteById(int id);
    List<Mill> getAll();

    Producer getProducerForMill(int millId);

    List<Mill> search(int beginYear, int endYear, String producerName);
}
