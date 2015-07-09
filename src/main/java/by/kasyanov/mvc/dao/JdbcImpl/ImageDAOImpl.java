package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.ImageDAO;
import by.kasyanov.mvc.model.Image;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String query = "select * from IMAGE";
        List<Image> imageList = new ArrayList<Image>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setSrc(rs.getString("SRC"));
                image.setMillId(rs.getInt("MILL_ID"));

                imageList.add(image);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {rs.close(); rs = null;}
                if (ps != null) { ps.close(); ps = null;}
                if (con != null) { con.close(); con = null;}
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return imageList;
    }
}
