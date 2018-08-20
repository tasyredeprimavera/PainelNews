package br.com.redeprimavera.painelnews.model.exception;

import java.sql.SQLException;

public class SQLConnectionException extends SQLException {

    public SQLConnectionException(String message) {
        super("Não foi possível conectar ao banco de dados!" + message);
    }
    
}
