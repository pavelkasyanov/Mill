package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.UserDAO;
import by.kasyanov.mvc.model.User;

import javax.sql.DataSource;
import java.util.List;

public class JdbcUserDAOImpl implements UserDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
