package ua.kpi.tef.mysql;

import ua.kpi.tef.dao.AbstractJDBCDao;
import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.PreventiveWork;
import ua.kpi.tef.entities.PreventiveWorkType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPreventiveWorkDAO extends AbstractJDBCDao<PreventiveWork, Integer> {
    @Override
    public String getSelectQuery() {
        return "SELECT id, type+0 AS type, date, hours_amount, id_machine FROM preventive_work";

    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO preventive_work (type,date,hours_amount,id_machine) VALUE (?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE preventive_work SET type = ?, date = ?,  hours_amount = ?, id_machine = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM preventive_work WHERE id = ?";
    }

    @Override
    protected List<PreventiveWork> parseResultSet(ResultSet rs) throws PersistException {
        List<PreventiveWork> result = new ArrayList<>();

        try {
            while (rs.next()) {
                PreventiveWork work = new PreventiveWork();
                work.setId(rs.getInt("id"));
                work.setType(PreventiveWorkType.values()[rs.getInt("type") - 1]);
                work.setDate(rs.getDate("date"));
                work.setHoursAmount(rs.getInt("hours_amount"));
                work.setMachineID(rs.getInt("id_machine"));
                result.add(work);
            }
        } catch (SQLException e) {
            throw new PersistException();
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, PreventiveWork object) throws PersistException {
        try {
            statement.setInt(1, object.getType().ordinal() + 1);
            statement.setDate(2, new java.sql.Date(object.getDate().getTime()));
            statement.setInt(3, object.getHoursAmount());
            statement.setInt(4, object.getMachineID());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, PreventiveWork object) throws PersistException {
        try {
            statement.setInt(1, object.getType().ordinal() + 1);
            statement.setDate(2, new java.sql.Date(object.getDate().getTime()));
            statement.setInt(3, object.getHoursAmount());
            statement.setInt(4, object.getMachineID());
            statement.setInt(5, object.getId());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    public MySqlPreventiveWorkDAO(Connection connection) {
        super(connection);
    }

    @Override
    public PreventiveWork create() throws PersistException {
        return persist(new PreventiveWork());
    }
}
