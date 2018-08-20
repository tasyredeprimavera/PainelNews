package br.com.redeprimavera.painelnews.control;

import br.com.redeprimavera.painelnews.model.dao.factory.OracleConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Control implements IControl{
    
    private Connection connection;
    private final OracleConnectionFactory FACTORY = new OracleConnectionFactory();

    @Override
    public void begin() throws SQLException {
        connection = FACTORY.getConnection();
    }

    @Override
    public void end() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
}
