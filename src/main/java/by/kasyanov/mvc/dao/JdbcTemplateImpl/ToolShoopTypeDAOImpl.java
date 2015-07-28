package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.ToolShoopTypeDAO;
import by.kasyanov.mvc.dao.mapper.ToolShoopTypeMapper;
import by.kasyanov.mvc.entities.ToolShoopType;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ToolShoopTypeDAOImpl implements ToolShoopTypeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(ToolShoopType user) {

    }

    @Override
    public ToolShoopType getById(int id) {
        String query = "select * from tool_shoop_types where ID = ?";
        List<ToolShoopType> types = jdbcTemplate.query(query, new Object[]{id}, new ToolShoopTypeMapper());
        return types.get(0);
    }

    @Override
    public ToolShoopType getByName(String name) {
        String query = "select * from tool_shoop_types where name = ?";
        List<ToolShoopType> types = jdbcTemplate.query(query, new Object[]{name}, new ToolShoopTypeMapper());
        return types.get(0);
    }

    @Override
    public void update(ToolShoopType user) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<ToolShoopType> getAll() {
        String query = "select * from tool_shoop_types";
        List<ToolShoopType> toolShoopTypes = jdbcTemplate.query(query, new ToolShoopTypeMapper());

        return toolShoopTypes;
    }
}
