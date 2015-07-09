package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.model.Image;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper<Image> {

    @Override
    public Image mapRow(ResultSet resultSet, int i) throws SQLException {
        Image image = new Image();
        image.setId(resultSet.getInt("ID"));
        image.setSrc(resultSet.getString("SRC"));
        image.setMillId(resultSet.getInt("MILL_ID"));

        return image;
    }
}
