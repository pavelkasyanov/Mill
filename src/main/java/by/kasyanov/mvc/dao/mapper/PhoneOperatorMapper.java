package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.PhoneOperator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneOperatorMapper implements RowMapper<PhoneOperator> {

    @Override
    public PhoneOperator mapRow(ResultSet resultSet, int i) throws SQLException {
        PhoneOperator phoneOperator = new PhoneOperator();
        phoneOperator.setId(resultSet.getInt("ID"));
        phoneOperator.setName(resultSet.getString("NAME"));
        phoneOperator.setImage(resultSet.getString("IMAGE"));

        return phoneOperator;
    }
}
