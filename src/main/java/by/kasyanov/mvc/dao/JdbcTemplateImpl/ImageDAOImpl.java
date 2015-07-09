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
        String sql = "INSERT INTO images " +
                "(SRC, MILL_ID)" +
                "VALUES (?, ?)";

        jdbcTemplate.update(sql, new Object[]{image.getSrc(), image.getMillId()});
    }

    @Override
    public Image getById(int id) {
        String query = "select * from images where ID = ?";
        List<Image> images = jdbcTemplate.query(query, new Object[]{id}, new ImageMapper());
        return images.get(0);
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
