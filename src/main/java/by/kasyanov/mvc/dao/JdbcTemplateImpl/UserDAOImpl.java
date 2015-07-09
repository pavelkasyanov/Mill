package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.UserDAO;
import by.kasyanov.mvc.dao.mapper.UserMapper;
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
        String sql = "INSERT INTO users " +
                "(FIRST_NAME, SURNAME, PATRONYMIC, COMPANY_ID)" +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(),
                user.getSurName(),
                user.getPatronymic(),
                user.getCompanyId()
        });
    }

    @Override
    public User getById(int id) {
        String query = "select * from users where ID = ?";
        List<User> users = jdbcTemplate.query(query, new Object[]{id}, new UserMapper());
        return users.get(0);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<User> getAll() {
        String query = "select * from users";
        List<User> users = jdbcTemplate.query(query, new UserMapper());

        return users;
    }
}
