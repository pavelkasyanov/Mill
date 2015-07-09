package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.model.Mill;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MillDAOImpl implements MillDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Mill mill) {

    }

    @Override
    public Mill getById(int id) {
        return null;
    }

    @Override
    public void update(Mill mill) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Mill> getAll() {
        String query = "select * from MILL";
        List<Mill> millList = new ArrayList<Mill>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Mill mill = new Mill();
                mill.setId(rs.getInt("ID"));
                mill.setName(rs.getString("NAME"));
                mill.setProducerId(rs.getInt("PRODUCER_ID"));
                mill.setYear(rs.getInt("YEAR"));
                mill.setCncType(rs.getString("CNC_TYPE"));
                mill.setAxis(rs.getInt("AXIS"));
                mill.setMillStateId(rs.getInt("MILL_STATE_ID"));
                mill.setPrice(rs.getInt("PRICE"));
                mill.setImage(rs.getString("IMAGE"));
                mill.setSpecialOffer(rs.getBoolean("SPECIAL_OFFER"));
                mill.setDescription(rs.getString("DESCRIPTION"));
                mill.setCountryProducingId(rs.getInt("COUNTRY_PRODUCING_ID"));
                mill.setSizeX(rs.getInt("SIZE_X"));
                mill.setSizeY(rs.getInt("SIZE_Y"));
                mill.setSizeZ(rs.getInt("SIZE_Z"));
                mill.setSpeedUpX(rs.getFloat("SPEED_UP_X"));
                mill.setSpeedUpY(rs.getFloat("SPEED_UP_Y"));
                mill.setSpeedUpZ(rs.getFloat("SPEED_UP_Z"));
                mill.setSpindleSpeedMax(rs.getInt("SPINDLE_SPEED_MAX"));
                mill.setSpindleTaper(rs.getString("SPINDLE_TAPER"));
                mill.setSpindlePower(rs.getFloat("SPINDLE_POWER"));
                mill.setSpindleTorqueMax(rs.getInt("SPINDLE_TORQUE_MAX"));
                mill.setSpindleCooling(rs.getString("SPINDLE_COOLING"));
                mill.setSpindleWorkTime(rs.getInt("SPINDLE_WORK_TIME"));
                mill.setTableLength(rs.getInt("TABLE_LENGTH"));
                mill.setTableWidth(rs.getInt("TABLE_WIDTH"));
                mill.setTableWeightMax(rs.getInt("TABLE_WEIGHT_MAX"));
                mill.setToolShoopNumber(rs.getInt("TOOL_SHOOP_NUMBER"));
                mill.setToolShoopMaxD(rs.getInt("TOOL_SHOOP_MAX_D"));
                mill.setToolShoopWeightMax(rs.getInt("TOOL_SHOOP_WEIGHT_MAX"));
                mill.setToolShoopChangeTime(rs.getFloat("TOOL_SHOOP_CHANGE_TIME"));
                mill.setPositioningAccuracy(rs.getFloat("POSITIONING_ACCURACY"));
                mill.setPositioningRepeatability(rs.getFloat("POSITIONING_REPEATABILITY"));

                millList.add(mill);
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

        return millList;
    }
}
