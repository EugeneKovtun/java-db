package ua.kpi.tef.mysql;

import ua.kpi.tef.dao.AbstractJDBCDao;
import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.MachineType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlMachineTypeDAO extends AbstractJDBCDao<MachineType, Integer> {
    public MySqlMachineTypeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, name FROM machine_types";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO machine_types (name) VALUE (?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE machine_types SET name = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM machine_types WHERE id = ?";
    }

    @Override
    protected List<MachineType> parseResultSet(ResultSet rs) throws PersistException {
        List<MachineType> result = new ArrayList<>();
        try {
            while (rs.next()) {
                MachineType machineType = new MachineType();
                machineType.setId(rs.getInt("id"));
                machineType.setName(rs.getString("name"));
                result.add(machineType);
            }
        } catch (SQLException e) {
            throw new PersistException();
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, MachineType object) throws PersistException {
        try {
            statement.setString(1, object.getName());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, MachineType object) throws PersistException {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    @Override
    public MachineType create() throws PersistException {
        return persist(new MachineType());
    }
}
