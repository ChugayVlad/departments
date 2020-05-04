package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionBuilder {
    private static ConnectionBuilder instance;
    private DataSource ds;

    public static synchronized ConnectionBuilder getInstance() {
        if (instance == null) {
            instance = new ConnectionBuilder();
        }
        return instance;
    }

    private ConnectionBuilder() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/departments");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
