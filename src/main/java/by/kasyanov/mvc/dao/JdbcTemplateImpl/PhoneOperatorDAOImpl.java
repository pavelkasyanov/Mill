package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.PhoneOperatorDAO;
import by.kasyanov.mvc.dao.mapper.PhoneOperatorMapper;
import by.kasyanov.mvc.model.PhoneOperator;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PhoneOperatorDAOImpl implements PhoneOperatorDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(PhoneOperator phoneOperator) {

    }

    @Override
    public PhoneOperator getById(int id) {
        return null;
    }

    @Override
    public void update(PhoneOperator phoneOperator) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<PhoneOperator> getAll() {
        String query = "select * from phone_operator";
        List<PhoneOperator> phoneOperators = jdbcTemplate.query(query, new PhoneOperatorMapper());

        return phoneOperators;
    }
}
