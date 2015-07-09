package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.SkypeDAO;
import by.kasyanov.mvc.model.Skype;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class SkypeDAOImpl implements SkypeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
