package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.MillType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MillTypeMaper implements RowMapper<MillType> {
    @Override
    public MillType mapRow(ResultSet resultSet, int i) throws SQLException {

        MillType millType = new MillType();
        millType.setId(resultSet.getInt("id"));
        millType.setName(resultSet.getString("name"));

        return millType;
    }
}
