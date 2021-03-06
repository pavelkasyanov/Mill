package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.dao.mapper.MillStateMapper;
import by.kasyanov.mvc.entities.MillState;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLDataException;
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
        String sql = "INSERT INTO state_mill " +
                "(NAME)" +
                "VALUES (?)";
        jdbcTemplate.update(sql, new Object[]{millState.getName()});
    }

    @Override
    public MillState getById(int id) {
        String query = "select * from state_mill where ID = ?";
        try {
            List<MillState> states = jdbcTemplate.query(query, new Object[]{id}, new MillStateMapper());
            return states.get(0);
        }catch (IndexOutOfBoundsException e) {
            System.err.println("error get state_mill from param id=" + id);
        }
        catch (Exception e) {
            //e.printStackTrace();
        }

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

    @Override
    public MillState getByName(String name) {
        try {
            String query = "select * from state_mill where NAME=?";
            List<MillState> states = jdbcTemplate.query(query, new Object[]{name}, new MillStateMapper());
            return states.get(0);
        }catch (Exception e) {
            System.err.println("IndexOutOfBoundsException MillState.getByName:name=" + name);

            throw new RuntimeException("IndexOutOfBoundsException MillState.getByName:name=" + name);
        }
    }
}
