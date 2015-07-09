package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.PhoneOperatorDAO;
import by.kasyanov.mvc.model.PhoneOperator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneOperatorDAOImpl implements PhoneOperatorDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(PhoneOperator phoneOperator) {

    }

    @Override
    public PhoneOperator getById(int id) {
        return null;
    }

    @Override
    public void update(PhoneOperator phoneOperator) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<PhoneOperator> getAll() {
        String query = "select * from phone_operator";
        List<PhoneOperator> phoneOperatorList = new ArrayList<PhoneOperator>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                PhoneOperator phoneOperator = new PhoneOperator();
                phoneOperator.setId(rs.getInt("ID"));
                phoneOperator.setName(rs.getString("NAME"));
                phoneOperator.setImage(rs.getString("IMAGE"));

                phoneOperatorList.add(phoneOperator);
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

        return phoneOperatorList;
    }
}
