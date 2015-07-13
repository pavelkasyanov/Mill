package by.kasyanov.mvc.dao.mapper;

import by.kasyanov.mvc.entities.Mill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MillMapper implements RowMapper<Mill> {

    @Override
    public Mill mapRow(ResultSet resultSet, int i) throws SQLException {
        Mill mill = new Mill();
        mill.setId(resultSet.getInt("ID"));
        mill.setName(resultSet.getString("NAME"));
        mill.setProducerId(resultSet.getInt("PRODUCER_ID"));
        mill.setYear(resultSet.getInt("YEAR"));
        mill.setCncType(resultSet.getString("CNC_TYPE"));
        mill.setAxis(resultSet.getInt("AXIS"));
        mill.setMillStateId(resultSet.getInt("MILL_STATE_ID"));
        mill.setPrice(resultSet.getInt("PRICE"));
        mill.setImage(resultSet.getString("IMAGE"));
        mill.setSpecialOffer(resultSet.getBoolean("SPECIAL_OFFER"));
        mill.setDescription(resultSet.getString("DESCRIPTION"));
        mill.setCountryProducingId(resultSet.getInt("COUNTRY_PRODUCING_ID"));
        mill.setSizeX(resultSet.getInt("SIZE_X"));
        mill.setSizeY(resultSet.getInt("SIZE_Y"));
        mill.setSizeZ(resultSet.getInt("SIZE_Z"));
        mill.setSpeedUpX(resultSet.getFloat("SPEED_UP_X"));
        mill.setSpeedUpY(resultSet.getFloat("SPEED_UP_Y"));
        mill.setSpeedUpZ(resultSet.getFloat("SPEED_UP_Z"));
        mill.setSpindleSpeedMax(resultSet.getInt("SPINDLE_SPEED_MAX"));
        mill.setSpindleTaper(resultSet.getString("SPINDLE_TAPER"));
        mill.setSpindlePower(resultSet.getFloat("SPINDLE_POWER"));
        mill.setSpindleTorqueMax(resultSet.getInt("SPINDLE_TORQUE_MAX"));
        mill.setSpindleCooling(resultSet.getString("SPINDLE_COOLING"));
        mill.setSpindleWorkTime(resultSet.getInt("SPINDLE_WORK_TIME"));
        mill.setTableLength(resultSet.getInt("TABLE_LENGTH"));
        mill.setTableWidth(resultSet.getInt("TABLE_WIDTH"));
        mill.setTableWeightMax(resultSet.getInt("TABLE_WEIGHT_MAX"));
        mill.setToolShoopNumber(resultSet.getInt("TOOL_SHOOP_NUMBER"));
        mill.setToolShoopMaxD(resultSet.getInt("TOOL_SHOOP_MAX_D"));
        mill.setToolShoopWeightMax(resultSet.getInt("TOOL_SHOOP_WEIGHT_MAX"));
        mill.setToolShoopChangeTime(resultSet.getFloat("TOOL_SHOOP_CHANGE_TIME"));
        mill.setPositioningAccuracy(resultSet.getFloat("POSITIONING_ACCURACY"));
        mill.setPositioningRepeatability(resultSet.getFloat("POSITIONING_REPEATABILITY"));

        return mill;
    }
}
