package br.com.redeprimavera.painelnews.model.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {
    
    public Connection getConnection() throws SQLException;
            
}
