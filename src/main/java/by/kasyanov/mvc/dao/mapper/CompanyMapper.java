package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        Company company = new Company(
                resultSet.getInt("ID"),
                resultSet.getString("NAME"),
                resultSet.getString("CITY"),
                resultSet.getInt("COUNTRY_ID"),
                resultSet.getString("STREET"),
                resultSet.getString("HOME"),
                resultSet.getString("OFFICE"),
                resultSet.getInt("POSTCODE"),
                resultSet.getString("DESCRIPTION"),
                resultSet.getString("SITE")
        );

        return company;
    }
}
