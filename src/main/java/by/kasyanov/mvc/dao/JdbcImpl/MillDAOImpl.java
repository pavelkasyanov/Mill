package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.model.Mill;

import javax.sql.DataSource;
import java.util.List;

public class MillDAOImpl implements MillDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Mill mill) {

    }

    @Override
    public Mill getById(int id) {
        return null;
    }

    @Override
    public void update(Mill mill) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Mill> getAll() {
        return null;
    }
}
