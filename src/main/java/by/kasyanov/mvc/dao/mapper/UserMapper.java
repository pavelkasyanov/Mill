package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setEnabled(resultSet.getBoolean("enabled"));
        user.setId(resultSet.getInt("id"));

        return user;
    }
}
