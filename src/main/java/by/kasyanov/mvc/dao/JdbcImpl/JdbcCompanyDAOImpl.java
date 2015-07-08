package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.CompanyDAO;
import by.kasyanov.mvc.model.Company;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCompanyDAOImpl implements CompanyDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Company company) {
        String sql = "INSERT INTO COMPANY " +
                "(NAME, CITY, COUNTRY_ID, STREET, HOME, OFFICE, POSTCODE, DESCRIPTION, SITE)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, company.getName());
            ps.setString(2, company.getCity());
            ps.setInt(3, company.getCountryId());
            ps.setString(4, company.getStreet());
            ps.setString(5, company.getHome());
            ps.setString(6, company.getOffice());
            ps.setInt(7, company.getPostcode());
            ps.setString(8, company.getDescription());
            ps.setString(9, company.getSite());
            ps.executeUpdate();
            ps.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public Company getById(int id) {
        String sql = "SELECT * FROM COMPANY WHERE ID = ?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Company company = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                company = new Company(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("CITY"),
                        rs.getInt("COUNTRY_ID"),
                        rs.getString("STREET"),
                        rs.getString("HOME"),
                        rs.getString("OFFICE"),
                        rs.getInt("POSTCODE"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("SITE")
                );

            }

            rs.close();
            ps.close();

            return company;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                }catch (SQLException e) {}
            }
        }

        return null;
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Company> getAll() {
        String query = "select * from COMPANY";
        List<Company> companyList = new ArrayList<Company>();
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Company company = new Company(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("CITY"),
                        rs.getInt("COUNTRY_ID"),
                        rs.getString("STREET"),
                        rs.getString("HOME"),
                        rs.getString("OFFICE"),
                        rs.getInt("POSTCODE"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("SITE")
                );

                companyList.add(company);
            }

            rs.close();
            ps.close();
            conn.close();
        }catch (SQLException e) {

        }

        return companyList;
    }
}
