package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.model.MillState;

import javax.sql.DataSource;
import java.util.List;

public class JdbcMillStateDAOImpl implements MillStateDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(MillState millState) {
    }

    @Override
    public MillState getById(int id) {
        return null;
    }

    @Override
    public void update(MillState millState) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<MillState> getAll() {
        return null;
    }
}
