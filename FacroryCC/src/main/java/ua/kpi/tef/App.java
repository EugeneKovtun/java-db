package ua.kpi.tef;

import ua.kpi.tef.dao.PersistException;
import ua.kpi.tef.entities.PreventiveWorkType;
import ua.kpi.tef.mysql.MySqlDaoFactory;

import java.sql.Connection;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws PersistException {
        Connection connection = new MySqlDaoFactory().getContext();
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Date dateq = sqlDate;
        System.out.println(date + " " + sqlDate + " " + dateq);
        System.out.println(PreventiveWorkType.values()[0]);


    }
}
