package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.Phone;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneMapper implements RowMapper<Phone> {

    @Override
    public Phone mapRow(ResultSet resultSet, int i) throws SQLException {
        Phone phone = new Phone();
        phone.setId(resultSet.getInt("ID"));
        phone.setCompanyId(resultSet.getInt("ID_COMPANY"));
        phone.setUserId(resultSet.getInt("ID_USER"));
        phone.setNumber(resultSet.getString("NUMBER"));
        phone.setOperatorId(resultSet.getInt("ID_OPERATOR"));

        return phone;
    }
}
