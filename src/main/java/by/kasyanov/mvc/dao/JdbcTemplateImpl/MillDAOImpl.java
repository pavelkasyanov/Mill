package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.mapper.MillMapper;
import by.kasyanov.mvc.entities.Mill;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
    public int insert(Mill mill) {
        String sql = "INSERT INTO mills " +
                "(product_id, mill_type, model, producer_id, country_producing_id, cnc_type, year, machine_location, axis_count, " +
                "moving_x, moving_y, moving_z, table_length, table_width, table_weight_max, spindle_taper, spindle_speed_max," +
                "spindle_power, spindle_torque_max, spindle_type, spindle_cooling, tool_shoop_type, tool_shoop_number," +
                "tool_shoop_max_d, tool_shoop_weight_max, tool_shoop_change_time, positioning_accuracy, positioning_repeatability," +
                "spindle_work_time, work_time, additional_configuration, mill_state_id, price, added_by_id)" +
                "VALUES (:productId, :millType, :model, :producerId, :countryProducingId, :cncType, :year, :machineLocation, :axisCount," +
                ":movingX, :movingY, :movingZ, :tableLength, :tableWidth, :tableWeightMax, :spindleTaper, :spindleSpeedMax,"+
                ":spindlePower, :spindleTorqueMax, :spindleType, :spindleCooling, :toolShoopType, :toolShoopNumber," +
                ":toolShoopMaxD, :toolShoopWeightMax, :toolShoopChangeTime, :positioningAccuracy, :positioningRepeatability, :spindleWorkTime," +
                ":workTime, :additionalConfiguration, :millStateId, :price, :addedById)";

        BeanPropertySqlParameterSource parameterSource= new BeanPropertySqlParameterSource(mill);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, parameterSource, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public Mill getById(int id) {
        String query = "select * from mills where ID=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
        Mill mill = jdbcTemplate.queryForObject(query, namedParameters, new MillMapper());
        return mill;
    }

    @Override
    public void update(Mill mill) {

    }

    @Override
    public void deleteById(int id) {
        String query = "delete from mills where id=:id";
        SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        jdbcTemplate.update(query, paramSource);
    }

    @Override
    public List<Mill> getAll() {
        String query = "select * from mills";
        List<Mill> mills = jdbcTemplate.query(query, new MillMapper());

        return mills;
    }

    @Override
    public List<Mill> sortByManufactureDate(int beginManufacture, int endManufacture) {
        String query = "select * from mills where YEAR >= :begin  AND YEAR  <= :end";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("begin", beginManufacture);
        params.put("end", endManufacture);
        SqlParameterSource paramSource = new MapSqlParameterSource(params);
        List<Mill> mills = jdbcTemplate.query(query, paramSource, new MillMapper());

        return mills;
    }
}
