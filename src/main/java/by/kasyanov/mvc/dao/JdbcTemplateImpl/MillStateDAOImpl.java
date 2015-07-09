package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.dao.mapper.MillStateMapper;
import by.kasyanov.mvc.model.MillState;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MillStateDAOImpl implements MillStateDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(MillState millState) {

    }

    @Override
    public MillState getById(int id) {
        return null;
    }

    @Override
    public void update(MillState millState) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<MillState> getAll() {
        String query = "select * from state_mill";
        List<MillState> millStates = jdbcTemplate.query(query, new MillStateMapper());

        return millStates;
    }
}
