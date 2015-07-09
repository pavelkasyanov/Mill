package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.ImageDAO;
import by.kasyanov.mvc.model.Image;

import javax.sql.DataSource;
import java.util.List;

public class ImageDAOImpl implements ImageDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
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
        return null;
    }
}
