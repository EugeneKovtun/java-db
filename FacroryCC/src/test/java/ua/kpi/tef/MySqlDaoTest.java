package ua.kpi.tef;

import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import ua.kpi.tef.dao.DaoFactory;
import ua.kpi.tef.dao.GenericDao;
import ua.kpi.tef.dao.Identified;
import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.*;
import ua.kpi.tef.mysql.MySqlDaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;


public class MySqlDaoTest extends GenericDaoTest<Connection> {

    private Connection connection;

    private GenericDao dao;

    private static final DaoFactory<Connection> factory = new MySqlDaoFactory();

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[][]{
                {Machine.class, new Machine()},
                {Client.class, new Client()},
                {MachineType.class, new MachineType()},
                {PreventiveWork.class, new PreventiveWork()},
                {Request.class, new Request()}
        });
    }

    @Before
    public void setUp() throws PersistException, SQLException {
        connection = factory.getContext();
        connection.setAutoCommit(false);
        dao = factory.getDao(connection, daoClass);
    }

    @After
    public void tearDown() throws SQLException {
        context().rollback();
        context().close();
    }

    @Override
    public GenericDao dao() {
        return dao;
    }

    @Override
    public Connection context() {
        return connection;
    }

    public MySqlDaoTest(Class clazz, Identified<Integer> notPersistedDto) {
        super(clazz, notPersistedDto);
    }
}
