package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.MillOptionDAO;
import by.kasyanov.mvc.dao.mapper.MIllOptionMapper;
import by.kasyanov.mvc.model.MillOption;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MillOptionDAOImpl implements MillOptionDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(MillOption millOption) {
        String sql = "INSERT INTO options_mill " +
                "(NAME, ID_MILL)" +
                "VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{millOption.getName(),
                millOption.getMillId()
        });
    }

    @Override
    public MillOption getById(int id) {
        return null;
    }

    @Override
    public void update(MillOption millOption) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<MillOption> getAll() {
        String query = "select * from options_mill";
        List<MillOption> millOptions = jdbcTemplate.query(query, new MIllOptionMapper());

        return millOptions;
    }
}
