package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.model.Producer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProducerDAOImpl implements ProducerDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Producer producer) {

    }

    @Override
    public Producer getById(int id) {
        return null;
    }

    @Override
    public void update(Producer producer) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Producer> getAll() {
        return null;
    }
}
