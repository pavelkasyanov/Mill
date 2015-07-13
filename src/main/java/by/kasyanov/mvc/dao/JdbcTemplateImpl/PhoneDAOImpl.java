package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.PhoneDAO;
import by.kasyanov.mvc.dao.mapper.PhoneMapper;
import by.kasyanov.mvc.entities.Phone;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Phone phone) {
        String sql = "INSERT INTO phones " +
                "(ID_COMPANY, ID_USER, NUMBER, ID_OPERATOR)" +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{phone.getCompanyId(),
                phone.getUserId(),
                phone.getNumber(),
                phone.getOperatorId()
        });
    }

    @Override
    public Phone getById(int id) {
        String query = "select * from phones where ID = ?";
        List<Phone> phones = jdbcTemplate.query(query, new Object[]{id}, new PhoneMapper());
        return phones.get(0);
    }

    @Override
    public void update(Phone phone) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Phone> getAll() {
        String query = "select * from phones";
        List<Phone> phones = jdbcTemplate.query(query, new PhoneMapper());

        return phones;
    }
}
