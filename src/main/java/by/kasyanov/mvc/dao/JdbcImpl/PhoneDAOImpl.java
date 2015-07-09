package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.PhoneDAO;
import by.kasyanov.mvc.model.Phone;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Phone phone) {

    }

    @Override
    public Phone getById(int id) {
        return null;
    }

    @Override
    public void update(Phone phone) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Phone> getAll() {
        String query = "select * from phones";
        List<Phone> phoneList = new ArrayList<Phone>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Phone phone = new Phone();
                phone.setId(rs.getInt("ID"));
                phone.setCompanyId(rs.getInt("ID_COMPANY"));
                phone.setUserId(rs.getInt("ID_USER"));
                phone.setNumber(rs.getString("NUMBER"));
                phone.setOperatorId(rs.getInt("ID_OPERATOR"));

                phoneList.add(phone);
            }
        }catch (SQLException e) {
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

        return phoneList;
    }
}
