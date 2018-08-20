package br.com.redeprimavera.painelnews.control;

import java.sql.SQLException;

public interface IControl {

    public void begin() throws SQLException;
    
    public void end() throws SQLException;
    
}
