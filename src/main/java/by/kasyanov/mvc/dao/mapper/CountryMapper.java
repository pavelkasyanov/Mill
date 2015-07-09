package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.model.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        country.setId(resultSet.getInt("ID"));
        country.setName(resultSet.getString("NAME"));
        country.setImage(resultSet.getString("IMAGE"));

        return country;
    }
}
