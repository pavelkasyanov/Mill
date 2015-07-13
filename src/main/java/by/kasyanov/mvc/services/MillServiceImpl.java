package by.kasyanov.mvc.services;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.Producer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MillServiceImpl implements MillService {

    @Autowired
    MillDAO millDAO;
    @Autowired
    ProducerDAO producerDAO;

    @Override
    public void insert(Mill mill) {
        millDAO.insert(mill);
    }

    @Override
    public Mill getById(int id) {
        return millDAO.getById(id);
    }

    @Override
    public void update(Mill mill) {
        millDAO.update(mill);
    }

    @Override
    public void deleteById(int id) {
        millDAO.deleteById(id);
    }

    @Override
    public List<Mill> getAll() {
        return millDAO.getAll();
    }

    @Override
    public Producer getProducerForMill(int millId) {
        return producerDAO.getById(millDAO.getById(millId).getProducerId());
    }

    @Override
    public List<Mill> search(int beginYear, int endYear, String producerName) {
        List<Mill> mills  = null;

        if (beginYear == -1) {
            beginYear = 0;
        }

        if (endYear == -1) {
            endYear = (Calendar.getInstance().get(Calendar.YEAR) + 1);
        }

        mills = millDAO.sortByManufactureDate(beginYear, endYear);

        if (mills  == null) return mills;

        if (producerName != null && producerName != "") {
            mills = this.selectByProducer(mills, producerName);
        }

        return mills;
    }

    private List<Mill> selectByProducer(List<Mill> millList, String producerName) {

        final Producer producer = producerDAO.getByName(producerName);

        List<Mill> result = new ArrayList<Mill>();

        for(Mill item : millList) {
            if (item.getProducerId() == producer.getId()) {
                result.add(item);
            }
        }

        return result;
    }
}
