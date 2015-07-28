package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.Mill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MillMapper implements RowMapper<Mill> {

    @Override
    public Mill mapRow(ResultSet rs, int i) throws SQLException {
        Mill mill = new Mill();
        mill.setId(rs.getInt("id"));
        mill.setProductId(rs.getString("product_id"));
        mill.setMillType(rs.getInt("mill_type"));
        mill.setModel(rs.getString("model"));
        mill.setProducerId(rs.getInt("producer_id"));
        mill.setCountryProducingId(rs.getInt("country_producing_id"));
        mill.setCncType(rs.getString("cnc_type"));
        mill.setYear(rs.getInt("year"));
        mill.setMachineLocation(rs.getInt("machine_location"));
        mill.setAxisCount(rs.getInt("axis_count"));
        mill.setMovingX(rs.getInt("moving_x"));
        mill.setMovingY(rs.getInt("moving_y"));
        mill.setMovingZ(rs.getInt("moving_z"));
        mill.setTableLength(rs.getInt("table_length"));
        mill.setTableWidth(rs.getInt("table_width"));
        mill.setTableWeightMax(rs.getInt("table_weight_max"));
        mill.setSpindleTaper(rs.getString("spindle_taper"));
        mill.setSpindleSpeedMax(rs.getInt("spindle_speed_max"));
        mill.setSpindlePower(rs.getString("spindle_power"));
        mill.setSpindleTorqueMax(rs.getInt("spindle_torque_max"));
        mill.setSpindleType(rs.getString("spindle_type"));
        mill.setSpindleCooling(rs.getString("spindle_cooling"));
        mill.setToolShoopType(rs.getInt("tool_shoop_type"));
        mill.setToolShoopNumber(rs.getInt("tool_shoop_number"));
        mill.setToolShoopMaxD(rs.getInt("tool_shoop_max_d"));
        mill.setToolShoopWeightMax(rs.getInt("tool_shoop_weight_max"));
        mill.setToolShoopChangeTime(rs.getFloat("tool_shoop_change_time"));
        mill.setPositioningAccuracy(rs.getFloat("positioning_accuracy"));
        mill.setPositioningRepeatability(rs.getFloat("positioning_repeatability"));
        mill.setSpindleWorkTime(rs.getInt("spindle_work_time"));
        mill.setWorkTime(rs.getInt("work_time"));
        mill.setAdditionalConfiguration(rs.getString("additional_configuration"));
        mill.setMillStateId(rs.getInt("mill_state_id"));
        mill.setPrice(rs.getInt("price"));
        mill.setAddedDate(rs.getDate("added_date"));
        mill.setAddedById(rs.getInt("added_by_id"));

        return mill;
    }
}
