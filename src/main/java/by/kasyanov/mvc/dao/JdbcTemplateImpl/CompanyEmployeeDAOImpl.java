package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.CompanyEmployeeDAO;
import by.kasyanov.mvc.dao.mapper.CompanyEmployeeMapper;
import by.kasyanov.mvc.entities.CompanyEmployee;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CompanyEmployeeDAOImpl implements CompanyEmployeeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(CompanyEmployee companyEmployee) {
        String sql = "INSERT INTO company_employees " +
                "(FIRST_NAME, SURNAME, PATRONYMIC, COMPANY_ID)" +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{companyEmployee.getFirstName(),
                companyEmployee.getSurName(),
                companyEmployee.getPatronymic(),
                companyEmployee.getCompanyId()
        });
    }

    @Override
    public CompanyEmployee getById(int id) {
        String query = "select * from company_employees where ID = ?";
        List<CompanyEmployee> companyEmployees = jdbcTemplate.query(query, new Object[]{id}, new CompanyEmployeeMapper());
        return companyEmployees.get(0);
    }

    @Override
    public void update(CompanyEmployee companyEmployee) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<CompanyEmployee> getAll() {
        String query = "select * from company_employees";
        List<CompanyEmployee> companyEmployees = jdbcTemplate.query(query, new CompanyEmployeeMapper());

        return companyEmployees;
    }
}
