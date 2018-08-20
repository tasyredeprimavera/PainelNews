package br.com.redeprimavera.painelnews.model.exception;

import java.sql.SQLException;

public class SQLAlterSessionDateFormatException extends SQLException {
    
    public SQLAlterSessionDateFormatException(String message) {
        super("Não foi possível alterar o formato de data da conexão!" + message);
    }
    
}
