package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.EmailDAO;
import by.kasyanov.mvc.model.Email;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOImpl implements EmailDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Email email) {

    }

    @Override
    public Email getById(int id) {
        return null;
    }

    @Override
    public void update(Email email) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Email> getAll() {
        String query = "select * from EMAIL";
        List<Email> emailList = new ArrayList<Email>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Email email = new Email();
                email.setId(rs.getInt("ID"));
                email.setCompanyId(rs.getInt("ID_COMPANY"));
                email.setUserId(rs.getInt("ID_USER"));
                email.setEmail(rs.getString("EMAIL"));

                emailList.add(email);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) { rs.close(); rs = null;}
                if (ps != null) { ps.close(); ps = null;}
                if (con != null) { con.close(); con = null;}
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
