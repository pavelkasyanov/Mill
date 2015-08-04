package by.kasyanov.mvc.dao.JdbcTemplateImpl;


import by.kasyanov.mvc.dao.MillTypeDAO;
import by.kasyanov.mvc.entities.MillType;
import by.kasyanov.mvc.dao.mapper.MillTypeMaper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MillTypeDAOImpl implements MillTypeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(MillType millOption) {
    }

    @Override
    public MillType getById(int id) {
        String query = "select * from mill_types where id = ?";
        try {
            List<MillType> states = jdbcTemplate.query(query, new Object[]{id}, new MillTypeMaper());
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
    public MillType getByName(String name) {
        String query = "select * from mill_types where name = ?";
        try {
            List<MillType> states = jdbcTemplate.query(query, new Object[]{name}, new MillTypeMaper());
            return states.get(0);
        }catch (IndexOutOfBoundsException e) {
            System.err.println("error get state_mill from param name=" + name);
        }
        catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(MillType millOption) {

    }

    @Override
    public void deleteById(int id) {
    }

    @Override
    public List<MillType> getAll() {
        String query = "select * from mill_types";
        List<MillType> millStates = jdbcTemplate.query(query, new MillTypeMaper());

        return millStates;
    }
}
