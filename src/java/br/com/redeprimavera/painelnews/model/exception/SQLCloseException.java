package br.com.redeprimavera.painelnews.model.exception;

import java.sql.SQLException;

public class SQLCloseException extends SQLException {

    public SQLCloseException(String message) {
        super("Não foi possível fechar o objeto da conexão!\n" + message);
    }
    
}
