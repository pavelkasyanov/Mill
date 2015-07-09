package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.CompanyDAO;
import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.model.Company;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Company company) {

    }

    @Override
    public Company getById(int id) {
        return null;
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Company> getAll() {
        return null;
    }
}
