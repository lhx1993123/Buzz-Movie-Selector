package com.lightningfalcons;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.resource.spi.Connector;

/**
 * Database class helps to make the connection to mysql database
 *
 * @author Yufan
 */
public class Database {

    /**
     * Get the connection to database
     *
     * @return Connection a connection to database
     */
    public static Connection openConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql379635?use"
            + "Unicode=true&characterEncoding=utf-8";
        String username = "sql379635";
        Properties properties = new Properties();
        String password = "";

        try {
            try (InputStream in = Database.class.getResourceAsStream("DBpro"
                + "perties")) {
                if (in == null) {
                    throw new NullPointerException("DBproperties does not"
                        + " exist");
                }
                properties.load(in);
                password = properties.getProperty("DBPassword");
            }
        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Close the connection which was opened before
     *
     * @param conn a Connection
     */
    public static void closeConn(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
