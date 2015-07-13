package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("ID"));
        user.setFirstName(resultSet.getString("FIRST_NAME"));
        user.setSurName(resultSet.getString("SURNAME"));
        user.setPatronymic(resultSet.getString("PATRONYMIC"));
        user.setCompanyId(resultSet.getInt("COMPANY_ID"));

        return user;
    }
}
