package ua.kpi.tef.mysql;

import ua.kpi.tef.dao.AbstractJDBCDao;
import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlRequestDAO extends AbstractJDBCDao<Request, Integer> {
    @Override
    public String getSelectQuery() {
        return "SELECT id, " +
                "id_client,start_date, " +
                "end_date,hours_amount, " +
                "id_machine FROM request";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO request " +
                "(id_client,start_date,end_date,hours_amount,id_machine) " +
                "VALUE (?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE request" +
                "SET id_client = ?, start_date = ?," +
                "end_date = ?, hours_amount = ?, id_machine = ?" +
                "WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM request WHERE id = ?";
    }

    @Override
    protected List<Request> parseResultSet(ResultSet rs) throws PersistException {
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Request object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Request object) throws PersistException {
        try {
            statement.setInt(1,object.getClientId());
            statement.setDate(2,new java.sql.Date(object.getStartDate().getTime()));
            statement.setDate(3,new java.sql.Date(object.getEndDate().getTime()));
            statement.setInt(4,object.getHoursAmount());
            statement.setInt(5,object.getIdMachine());
            statement.setInt(6,object.getId());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    public MySqlRequestDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Request create() throws PersistException {
        return null;
    }
}
