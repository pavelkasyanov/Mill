package by.kasyanov.mvc.services;

import by.kasyanov.mvc.Models.MillModel;
import by.kasyanov.mvc.entities.Image;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.MillState;
import by.kasyanov.mvc.entities.Producer;
import by.kasyanov.mvc.exceptions.ModelMappingExeption;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface MillService {
    void insert(Mill mill);
    Mill getById(int id);
    void update(Mill mill);
    void deleteById(int id);
    List<Mill> getAll();

    Producer getProducerForMill(int millId);

    List<Mill> search(int beginYear, int endYear, String producerName,
                      int minLongitudinalTravelX,
                      int maxLongitudinalTravelX,
                      int minTransversalTravelY,
                      int maxTransversalTravelY,
                      int minVerticalTravelZ,
                      int maxVerticalTravelZ,
                      String cnc,
                      int minTableLength,
                      int maxTableLength,
                      int minTableWidth,
                      int maxTableWidth);

    String addMillFromFile(MultipartFile file);

    MillState getMillState(int MillId);

    Map<Integer, Image> getMillsImages();

    MillModel getMillModelById(int millId) throws ModelMappingExeption;
}
