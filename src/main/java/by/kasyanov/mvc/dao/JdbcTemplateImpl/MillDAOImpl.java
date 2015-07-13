package by.kasyanov.mvc.dao.JdbcTemplateImpl;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.mapper.MillMapper;
import by.kasyanov.mvc.entities.Mill;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MillDAOImpl implements MillDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Mill mill) {
        //32 params + id
        String sql = "INSERT INTO mill " +
                "(NAME, PRODUCER_ID, 'YEAR', CNC_TYPE, AXIS, MILL_STATE_ID, PRICE, IMAGE, SPECIAL_OFFER, DESCRIPTION, " +
                "COUNTRY_PRODUCING_ID, SIZE_X, SIZE_Y, SIZE_Z, SPEED_UP_X, SPEED_UP_Y, SPEED_UP_Z, SPINDLE_SPEED_MAX" +
                "SPINDLE_TAPER, SPINDLE_POWER, SPINDLE_TORQUE_MAX, SPINDLE_COOLING, SPINDLE_WORK_TIME, TABLE_LENGTH" +
                "TABLE_WIDTH, TABLE_WEIGHT_MAX, TOOL_SHOOP_NUMBER, TOOL_SHOOP_MAX_D, TOOL_SHOOP_WEIGHT_MAX," +
                "TOOL_SHOOP_CHANGE_TIME, POSITIONING_ACCURACY, POSITIONING_REPEATABILITY)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{mill.getName(),
                mill.getProducerId(),
                mill.getYear(),
                mill.getCncType(),
                mill.getAxis(),
                mill.getMillStateId(),
                mill.getPrice(),
                mill.getImage(),
                mill.getSpecialOffer(),
                mill.getDescription(),
                mill.getCountryProducingId(),
                mill.getSizeX(),
                mill.getSizeY(),
                mill.getSizeZ(),
                mill.getSpeedUpX(),
                mill.getSpeedUpY(),
                mill.getSpeedUpZ(),
                mill.getSpindleSpeedMax(),
                mill.getSpindleTaper(),
                mill.getSpindlePower(),
                mill.getSpindleTorqueMax(),
                mill.getSpindleCooling(),
                mill.getSpindleWorkTime(),
                mill.getTableLength(),
                mill.getTableWidth(),
                mill.getTableWeightMax(),
                mill.getToolShoopNumber(),
                mill.getToolShoopMaxD(),
                mill.getToolShoopWeightMax(),
                mill.getToolShoopChangeTime(),
                mill.getPositioningAccuracy(),
                mill.getPositioningRepeatability()
        });
    }

    @Override
    public Mill getById(int id) {
        String query = "select * from mill where ID = ?";
        List<Mill> images = jdbcTemplate.query(query, new Object[]{id}, new MillMapper());
        return images.get(0);
    }

    @Override
    public void update(Mill mill) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Mill> getAll() {
        String query = "select * from mill";
        List<Mill> mills = jdbcTemplate.query(query, new MillMapper());

        return mills;
    }
}
