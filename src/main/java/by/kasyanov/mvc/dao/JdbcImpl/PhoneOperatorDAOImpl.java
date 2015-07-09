package by.kasyanov.mvc.dao.JdbcImpl;

import by.kasyanov.mvc.dao.PhoneOperatorDAO;
import by.kasyanov.mvc.model.PhoneOperator;

import javax.sql.DataSource;
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
        return null;
    }
}
