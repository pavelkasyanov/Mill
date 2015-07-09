package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.ImageDAO;
import by.kasyanov.mvc.dao.mapper.ImageMapper;
import by.kasyanov.mvc.model.Image;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ImageDAOImpl implements ImageDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Image image) {

    }

    @Override
    public Image getById(int id) {
        return null;
    }

    @Override
    public void update(Image image) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Image> getAll() {
        String query = "select * from images";
        List<Image> images = jdbcTemplate.query(query, new ImageMapper());

        return images;
    }
}
