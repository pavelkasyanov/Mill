package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.ToolShoopType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToolShoopTypeMapper implements RowMapper<ToolShoopType> {
    @Override
    public ToolShoopType mapRow(ResultSet resultSet, int i) throws SQLException {

        ToolShoopType toolShoopType = new ToolShoopType();
        toolShoopType.setId(resultSet.getInt("id"));
        toolShoopType.setName(resultSet.getString("name"));

        return toolShoopType;
    }
}
