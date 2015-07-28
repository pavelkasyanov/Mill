package by.kasyanov.mvc.dao;

import by.kasyanov.mvc.entities.Image;

import java.util.List;

public interface ImageDAO {
    void insert(Image image);
    Image getById(int id);
    void update(Image image);
    void deleteById(int id);
    List<Image> getAll();

    List<Image> getImagesFromMill(int millId);
}
