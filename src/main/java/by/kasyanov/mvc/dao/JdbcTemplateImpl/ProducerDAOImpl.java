package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.dao.mapper.ProducerMapper;
import by.kasyanov.mvc.entities.Producer;
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
        String sql = "INSERT INTO producer " +
                "(NAME)" +
                "VALUES (?)";
        jdbcTemplate.update(sql, new Object[]{producer.getName()});
    }

    @Override
    public Producer getById(int id) {
        String query = "select * from producer where ID = ?";
        List<Producer> producers = jdbcTemplate.query(query, new Object[]{id}, new ProducerMapper());
        return producers.get(0);
    }

    @Override
    public void update(Producer producer) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Producer> getAll() {
        String query = "select * from producer";
        List<Producer> producers = jdbcTemplate.query(query, new ProducerMapper());

        return producers;
    }
}
