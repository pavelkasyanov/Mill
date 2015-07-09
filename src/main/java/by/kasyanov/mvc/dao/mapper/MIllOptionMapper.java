package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.model.MillOption;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MIllOptionMapper implements RowMapper<MillOption> {

    @Override
    public MillOption mapRow(ResultSet resultSet, int i) throws SQLException {
        MillOption millOption = new MillOption();
        millOption.setId(resultSet.getInt("ID"));
        millOption.setName(resultSet.getString("NAME"));
        millOption.setMillId(resultSet.getInt("ID_MILL"));

        return millOption;
    }
}
