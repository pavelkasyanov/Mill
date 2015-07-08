package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.EmailDAO;
import by.kasyanov.mvc.model.Email;

import javax.sql.DataSource;
import java.util.List;

public class JdbcEmailDAOImpl implements EmailDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Email email) {

    }

    @Override
    public Email getById(int id) {
        return null;
    }

    @Override
    public void update(Email email) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Email> getAll() {
        return null;
    }
}
