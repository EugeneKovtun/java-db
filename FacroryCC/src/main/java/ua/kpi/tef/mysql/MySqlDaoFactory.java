package ua.kpi.tef.mysql;

import ua.kpi.tef.dao.DaoFactory;
import ua.kpi.tef.dao.GenericDao;
import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory<Connection> {

    private final String user = "root";//Логин пользователя
    private final String password = "root";//Пароль пользователя
    private final String url = "jdbc:mysql://localhost:3306/dispatching_service";//URL адрес
    private final String driver = "com.mysql.jdbc.Driver";//Имя драйвера
    private Map<Class, DaoCreator> creators;

    public Connection getContext() throws PersistException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<>();
        creators.put(Client.class,
                (DaoCreator<Connection>) connection -> new MySqlClientDAO(connection));
        creators.put(Machine.class,
                (DaoCreator<Connection>) connection -> new MySqlMachineDAO(connection));
        creators.put(MachineType.class,
                (DaoCreator<Connection>) connection -> new MySqlMachineTypeDAO(connection));
        creators.put(PreventiveWork.class,
                (DaoCreator<Connection>) connection -> new MySqlPreventiveWorkDAO(connection));
        creators.put(Request.class,
                (DaoCreator<Connection>) connection -> new MySqlRequestDAO(connection));
    }
}
