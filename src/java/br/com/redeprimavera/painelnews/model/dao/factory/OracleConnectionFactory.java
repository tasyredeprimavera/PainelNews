package br.com.redeprimavera.painelnews.model.dao.factory;

import br.com.redeprimavera.painelnews.model.exception.SQLConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class OracleConnectionFactory extends ConnectionFactory {

    public OracleConnectionFactory() {
        user = "painel";
        password = "P0T4syti";
        dataBase = "prd";
        host = "172.16.0.100";
        port = "1521";
        url = "jdbc:oracle:thin:@//" + host + ":" + port + "/" + dataBase;
        driver = "oracle.jdbc.driver.OracleDriver";
    }

    @Override
    public Connection getConnection() throws SQLConnectionException {
        try {
            Class.forName(driver);
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            execCommandSQL(conn, "alter session set NLS_DATE_FORMAT='DD-MM-YYYY'");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLConnectionException(e.getMessage());
        }
    }

    /*
    public static void main(String[] args) {
        OracleConnectionFactory conn = new OracleConnectionFactory();
        try {
            conn.getConnection();
            System.out.println(conn);
        } catch (SQLConnectionException ex) {
            ex.printStackTrace();
        }
    }
    */
    
}
