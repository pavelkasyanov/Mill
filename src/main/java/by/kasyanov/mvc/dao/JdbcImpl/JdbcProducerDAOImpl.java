package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.model.Producer;

import javax.sql.DataSource;
import java.util.List;

public class JdbcProducerDAOImpl implements ProducerDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Producer producer) {

    }

    @Override
    public Producer getById(int id) {
        return null;
    }

    @Override
    public void update(Producer producer) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Producer> getAll() {
        return null;
    }
}
