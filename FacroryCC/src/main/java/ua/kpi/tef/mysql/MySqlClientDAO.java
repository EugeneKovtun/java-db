package ua.kpi.tef.mysql;

import ua.kpi.tef.dao.AbstractJDBCDao;
import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlClientDAO extends AbstractJDBCDao<Client, Integer> {

    public MySqlClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, name FROM client";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO client (name) VALUE (?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE client SET name = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM client WHERE id = ?";
    }

    @Override
    protected List<Client> parseResultSet(ResultSet rs) throws PersistException {
        List<Client> result = new ArrayList<>();
        try {
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                result.add(client);
            }
        } catch (SQLException e) {
            throw new PersistException();
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Client object) throws PersistException {
        try {
            statement.setString(1, object.getName());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Client object) throws PersistException {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            throw new PersistException();
        }
    }

    @Override
    public Client create() throws PersistException {
        return persist(new Client());
    }
}
