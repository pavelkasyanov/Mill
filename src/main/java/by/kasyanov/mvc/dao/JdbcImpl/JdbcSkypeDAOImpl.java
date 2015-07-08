package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.SkypeDAO;
import by.kasyanov.mvc.model.Skype;

import javax.sql.DataSource;
import java.util.List;

public class JdbcSkypeDAOImpl implements SkypeDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Skype skype) {

    }

    @Override
    public Skype getById(int id) {
        return null;
    }

    @Override
    public void update(Skype skype) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Skype> getAll() {
        return null;
    }
}
