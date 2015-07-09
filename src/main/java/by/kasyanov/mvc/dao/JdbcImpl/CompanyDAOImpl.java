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

public class CompanyDAOImpl implements CompanyDAO {

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
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();

            ps = conn.prepareStatement(sql);
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

        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) {ps.close(); ps = null;}
                if (conn != null) {conn.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Company getById(int id) {
        String sql = "SELECT * FROM COMPANY WHERE ID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Company company = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {rs.close(); rs = null;}
                if (ps != null) {ps.close(); ps = null;}
                if (conn != null) {conn.close(); conn = null;}
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return company;
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
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

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

        }catch (SQLException e) {

        } finally {
            try {
                if (rs != null) {rs.close(); rs = null;}
                if (ps!= null) {ps.close(); ps = null;}
                if (conn != null) {conn.close(); conn = null;}
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return companyList;
    }
}
