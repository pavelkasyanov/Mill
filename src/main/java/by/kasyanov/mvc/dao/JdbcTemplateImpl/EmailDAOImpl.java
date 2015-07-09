package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.EmailDAO;
import by.kasyanov.mvc.dao.mapper.EmailMapper;
import by.kasyanov.mvc.model.Email;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmailDAOImpl implements EmailDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Email email) {
        String sql = "INSERT INTO emails " +
                "(ID_COMPANY, ID_USER, EMAIL)" +
                "VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{email.getCompanyId(),
                email.getUserId(),
                email.getEmail()
        });
    }

    @Override
    public Email getById(int id) {
        String query = "select * from emails where ID = ?";
        List<Email> emails = jdbcTemplate.query(query, new Object[]{id}, new EmailMapper());
        return emails.get(0);
    }

    @Override
    public void update(Email email) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Email> getAll() {
        String query = "select * from emails";
        List<Email> emails = jdbcTemplate.query(query, new EmailMapper());

        return emails;
    }
}
