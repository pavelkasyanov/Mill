package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.dao.mapper.CountryMapper;
import by.kasyanov.mvc.entities.Country;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Country country) {
        String sql = "INSERT INTO Countries " +
                "(NAME, IMAGE)" +
                "VALUES (?, ?)";

        jdbcTemplate.update(sql, new Object[]{country.getName(), country.getImage()});
    }

    @Override
    public void update(Country country) {
        String sql = "update Countries " +
                "set NAME = ?, IMAGE = ? " +
                " where id = ?";
        jdbcTemplate.update(sql, new Object[]{country.getName(),
                country.getImage(),
                country.getId()
        });
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from Countries " +
                "where ID = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public Country getById(int id) {
        String query = "select * from Countries where ID = ?";
         List<Country> country = jdbcTemplate.query(query, new Object[]{id}, new CountryMapper());
        return country.get(0);
    }

    @Override
    public List<Country> getAll() {
        String query = "select * from Countries";
        List<Country> countryList = jdbcTemplate.query(query, new CountryMapper());

        return countryList;
    }

    @Override
    public Country getByName(String name) {
        String query = "select * from Countries where NAME = ?";
        List<Country> country = jdbcTemplate.query(query, new Object[]{name}, new CountryMapper());
        return country.get(0);
    }
}
