package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.PhoneDAO;
import by.kasyanov.mvc.model.Phone;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Phone phone) {

    }

    @Override
    public Phone getById(int id) {
        return null;
    }

    @Override
    public void update(Phone phone) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Phone> getAll() {
        return null;
    }
}
