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
        String sql = "INSERT INTO phone_operator " +
                "(NAME, IMAGE)" +
                "VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{phoneOperator.getName(),
                phoneOperator.getImage()
        });
    }

    @Override
    public PhoneOperator getById(int id) {
        String query = "select * from phone_operator where ID = ?";
        List<PhoneOperator> phoneOperators = jdbcTemplate.query(query, new Object[]{id}, new PhoneOperatorMapper());
        return phoneOperators.get(0);
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
