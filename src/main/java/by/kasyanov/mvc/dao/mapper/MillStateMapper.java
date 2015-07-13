package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.MillState;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MillStateMapper implements RowMapper<MillState> {

    @Override
    public MillState mapRow(ResultSet resultSet, int i) throws SQLException {
        MillState millState = new MillState();
        millState.setId(resultSet.getInt("ID"));
        millState.setName(resultSet.getString("NAME"));

        return millState;
    }
}
