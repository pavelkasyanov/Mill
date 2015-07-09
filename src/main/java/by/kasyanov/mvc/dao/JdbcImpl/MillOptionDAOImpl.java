package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.MillOptionDAO;
import by.kasyanov.mvc.model.MillOption;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MillOptionDAOImpl implements MillOptionDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(MillOption millOption) {

    }

    @Override
    public MillOption getById(int id) {
        return null;
    }

    @Override
    public void update(MillOption millOption) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<MillOption> getAll() {
        String query = "select * from options_mill";
        List<MillOption> millOptionList = new ArrayList<MillOption>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                MillOption millOption = new MillOption();
                millOption.setId(rs.getInt("ID"));
                millOption.setName(rs.getString("NAME"));
                millOption.setMillId(rs.getInt("ID_MILL"));

                millOptionList.add(millOption);
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

        return millOptionList;
    }
}
