package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.CompanyEmployee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<CompanyEmployee> {

    @Override
    public CompanyEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
        CompanyEmployee companyEmployee = new CompanyEmployee();
        companyEmployee.setId(resultSet.getInt("ID"));
        companyEmployee.setFirstName(resultSet.getString("FIRST_NAME"));
        companyEmployee.setSurName(resultSet.getString("SURNAME"));
        companyEmployee.setPatronymic(resultSet.getString("PATRONYMIC"));
        companyEmployee.setCompanyId(resultSet.getInt("COMPANY_ID"));

        return companyEmployee;
    }
}
