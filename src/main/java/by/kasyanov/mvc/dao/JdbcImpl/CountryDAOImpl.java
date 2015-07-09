package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.model.Country;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Country country) {
        String sql = "INSERT INTO COUNTRY " +
                "(NAME, IMAGE)" +
                "VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = dataSource.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, country.getName());
            ps.setString(2, country.getImage());

            ps.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {ps.close(); ps = null;}
                if (conn != null) {conn.close(); conn = null;}
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Country getById(int id) {
        return null;
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Country> getAll() {
        String query = "select * from Country";
        List<Country> countryList = new ArrayList<Country>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("ID"));
                country.setName(rs.getString("NAME"));
                country.setImage(rs.getString("IMAGE"));

                countryList.add(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) { rs.close(); rs = null;}
                if (ps != null) { ps.close(); ps = null;}
                if (con != null) { con.close();  con = null;}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return countryList;
    }
}