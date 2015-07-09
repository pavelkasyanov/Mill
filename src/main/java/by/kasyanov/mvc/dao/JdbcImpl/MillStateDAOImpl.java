package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.model.MillState;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MillStateDAOImpl implements MillStateDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(MillState millState) {
    }

    @Override
    public MillState getById(int id) {
        return null;
    }

    @Override
    public void update(MillState millState) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<MillState> getAll() {
        String query = "select * from state_mill";
        List<MillState> millStateList = new ArrayList<MillState>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                MillState millState = new MillState();
                millState.setId(rs.getInt("ID"));
                millState.setName(rs.getString("NAME"));

                millStateList.add(millState);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {rs.close(); rs = null;}
                if (ps != null) {ps.close(); ps = null;}
                if (con != null) {con.close(); con = null;}
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return millStateList;
    }
}
