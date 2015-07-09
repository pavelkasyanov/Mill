package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.UserDAO;
import by.kasyanov.mvc.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
