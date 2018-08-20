package br.com.redeprimavera.painelnews.model.dao.factory;

import br.com.redeprimavera.painelnews.model.exception.SQLAlterSessionDateFormatException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConnectionFactory implements IConnectionFactory {

    protected String user;
    protected String password;
    protected String dataBase;
    protected String host;
    protected String port;
    protected String url;
    protected String driver;

    protected void execCommandSQL(Connection conn, String sql) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            throw new SQLAlterSessionDateFormatException(ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public String toString() {
        return url;
    }

}
