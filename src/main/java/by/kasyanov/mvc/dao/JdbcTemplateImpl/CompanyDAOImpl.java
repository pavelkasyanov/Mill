package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.CompanyDAO;
import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.dao.mapper.CompanyMapper;
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
        String sql = "INSERT INTO company " +
                "(NAME, CITY, COUNTRY_ID, STREET, HOME, OFFICE, POSTCODE, DESCRIPTION, SITE)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{company.getName(),
                company.getCity(),
                company.getCountryId(),
                company.getStreet(),
                company.getHome(),
                company.getOffice(),
                company.getPostcode(),
                company.getDescription(),
                company.getSite()
        });
    }

    @Override
    public Company getById(int id) {
        String query = "select * from company where ID = ?";
        List<Company> companies = jdbcTemplate.query(query, new Object[]{id}, new CompanyMapper());
        return companies.get(0);
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Company> getAll() {
        String query = "select * from Company";
        List<Company> companies = jdbcTemplate.query(query, new CompanyMapper());

        return companies;
    }
}
