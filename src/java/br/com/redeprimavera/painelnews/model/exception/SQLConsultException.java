package br.com.redeprimavera.painelnews.model.exception;

import java.sql.SQLException;

public class SQLConsultException extends SQLException {

    public SQLConsultException(String message) {
        super("Não foi possível realizar a consulta!\n" + message);
    }
    
}
