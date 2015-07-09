package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.model.Email;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailMapper implements RowMapper<Email> {

    @Override
    public Email mapRow(ResultSet resultSet, int i) throws SQLException {
        Email email = new Email();
        email.setId(resultSet.getInt("ID"));
        email.setCompanyId(resultSet.getInt("ID_COMPANY"));
        email.setUserId(resultSet.getInt("ID_USER"));
        email.setEmail(resultSet.getString("EMAIL"));

        return email;
    }
}
