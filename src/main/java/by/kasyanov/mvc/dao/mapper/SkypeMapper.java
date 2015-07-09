package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.model.Skype;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkypeMapper implements RowMapper<Skype> {

    @Override
    public Skype mapRow(ResultSet resultSet, int i) throws SQLException {
        Skype skype = new Skype();
        skype.setId(resultSet.getInt("ID"));
        skype.setCompanyId(resultSet.getInt("ID_COMPANY"));
        skype.setUserId(resultSet.getInt("ID_USER"));
        skype.setSkypeLogin(resultSet.getString("SKYPE"));

        return skype;
    }
}
