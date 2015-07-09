package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.SkypeDAO;
import by.kasyanov.mvc.dao.mapper.SkypeMapper;
import by.kasyanov.mvc.model.Skype;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class SkypeDAOImpl implements SkypeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Skype skype) {
        String sql = "INSERT INTO skype " +
                "(ID_COMPANY, ID_USER, SKYPE)" +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{skype.getCompanyId(),
                skype.getUserId(),
                skype.getSkypeLogin()
        });
    }

    @Override
    public Skype getById(int id) {
        String query = "select * from skype where ID = ?";
        List<Skype> skypes = jdbcTemplate.query(query, new Object[]{id}, new SkypeMapper());
        return skypes.get(0);
    }

    @Override
    public void update(Skype skype) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Skype> getAll() {
        String query = "select * from skype";
        List<Skype> skypes = jdbcTemplate.query(query, new SkypeMapper());

        return skypes;
    }
}
