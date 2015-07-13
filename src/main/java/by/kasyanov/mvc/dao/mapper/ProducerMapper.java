package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.Producer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProducerMapper implements RowMapper<Producer> {

    @Override
    public Producer mapRow(ResultSet resultSet, int i) throws SQLException {
        Producer producer = new Producer();
        producer.setId(resultSet.getInt("ID"));
        producer.setName(resultSet.getString("NAME"));

        return producer;
    }
}
