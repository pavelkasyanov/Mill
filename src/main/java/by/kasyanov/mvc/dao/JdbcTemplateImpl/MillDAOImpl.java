package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.mapper.MillMapper;
import by.kasyanov.mvc.model.Mill;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MillDAOImpl implements MillDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Mill mill) {

    }

    @Override
    public Mill getById(int id) {
        return null;
    }

    @Override
    public void update(Mill mill) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Mill> getAll() {
        String query = "select * from mill";
        List<Mill> mills = jdbcTemplate.query(query, new MillMapper());

        return mills;
    }
}
