package ua.kpi.tef.mysql;

import ua.kpi.tef.dao.AbstractJDBCDao;
import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.Machine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlMachineDAO extends AbstractJDBCDao<Machine, Integer> {
    @Override
    public String getSelectQuery() {
        return "SELECT id,type_id, name, price FROM machine";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO machine (type_id, name, price) VALUE (?, ?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE machine SET type_id = ?, name = ?, price = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM machine WHERE id = ?";
    }

    @Override
    protected List<Machine> parseResultSet(ResultSet rs) throws PersistException {
        List<Machine> machines = new ArrayList<>();
        try {
            while (rs.next()) {
                Machine machine = new Machine();
                machine.setId(rs.getInt("id"));
                machine.setName(rs.getString("name"));
                machine.setPrice(rs.getInt("price"));
                machine.setTypeId(rs.getInt("type_id"));
                machines.add(machine);
            }
        } catch (SQLException e) {
            throw new PersistException();
        }
        return machines;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Machine object) throws PersistException {
        try {
            statement.setInt(1, object.getTypeId());
            statement.setString(2, object.getName());
            statement.setInt(3, object.getPrice());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Machine object) throws PersistException {
        try {
            statement.setInt(1, object.getTypeId());
            statement.setString(2, object.getName());
            statement.setInt(3, object.getPrice());
            statement.setInt(4, object.getId());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    public MySqlMachineDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Machine create() throws PersistException {
        return persist(new Machine());
    }
}
