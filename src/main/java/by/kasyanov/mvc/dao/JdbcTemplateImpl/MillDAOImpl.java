package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.mapper.MillMapper;
import by.kasyanov.mvc.entities.Mill;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MillDAOImpl implements MillDAO {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(Mill mill) {
        String sql = "INSERT INTO mill " +
                "(NAME, PRODUCER_ID, YEAR, CNC_TYPE, AXIS, MILL_STATE_ID, PRICE, IMAGE, SPECIAL_OFFER, DESCRIPTION, " +
                "COUNTRY_PRODUCING_ID, SIZE_X, SIZE_Y, SIZE_Z, SPEED_UP_X, SPEED_UP_Y, SPEED_UP_Z, SPINDLE_SPEED_MAX," +
                "SPINDLE_TAPER, SPINDLE_POWER, SPINDLE_TORQUE_MAX, SPINDLE_COOLING, SPINDLE_WORK_TIME, TABLE_LENGTH," +
                "TABLE_WIDTH, TABLE_WEIGHT_MAX, TOOL_SHOOP_NUMBER, TOOL_SHOOP_MAX_D, TOOL_SHOOP_WEIGHT_MAX," +
                "TOOL_SHOOP_CHANGE_TIME, POSITIONING_ACCURACY, POSITIONING_REPEATABILITY)" +
                "VALUES (:name, :producerId, :year, :cncType, :axis, :millStateId, :price, :image, :specialOffer," +
                ":description, :countryProducingId, :sizeX, :sizeY, :sizeZ, :speedUpX, :speedUpY, :speedUpZ,"+
                ":spindleSpeedMax, :spindleTaper, :spindlePower, :spindleTorqueMax, :spindleCooling, :spindleWorkTime," +
                ":tableLength, :tableWidth, :tableWeightMax, :ToolShoopNumber, :ToolShoopMaxD, :ToolShoopWeightMax," +
                ":ToolShoopChangeTime, :positioningAccuracy, :positioningRepeatability)";

        BeanPropertySqlParameterSource parameterSource= new BeanPropertySqlParameterSource(mill);
        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public Mill getById(int id) {
        String query = "select * from mill where ID=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
        Mill mill = jdbcTemplate.queryForObject(query, namedParameters, new MillMapper());
        return mill;
    }

    @Override
    public void update(Mill mill) {

    }

    @Override
    public void deleteById(int id) {
        String query = "delete from mill where id=:id";
        SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        jdbcTemplate.update(query, paramSource);
    }

    @Override
    public List<Mill> getAll() {
        String query = "select * from mill";
        List<Mill> mills = jdbcTemplate.query(query, new MillMapper());

        return mills;
    }

    @Override
    public List<Mill> sortByManufactureDate(int beginManufacture, int endManufacture) {
        String query = "select * from mill where YEAR >= :begin  AND YEAR  <= :end";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("begin", beginManufacture);
        params.put("end", endManufacture);
        SqlParameterSource paramSource = new MapSqlParameterSource(params);
        List<Mill> mills = jdbcTemplate.query(query, paramSource, new MillMapper());

        return mills;
    }
}
