package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.MillOptionDAO;
import by.kasyanov.mvc.model.MillOption;

import javax.sql.DataSource;
import java.util.List;

public class MillOptionDAOImpl implements MillOptionDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(MillOption millOption) {

    }

    @Override
    public MillOption getById(int id) {
        return null;
    }

    @Override
    public void update(MillOption millOption) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<MillOption> getAll() {
        return null;
    }
}
