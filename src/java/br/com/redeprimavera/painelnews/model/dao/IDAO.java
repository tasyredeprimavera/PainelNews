package br.com.redeprimavera.painelnews.model.dao;

import br.com.redeprimavera.painelnews.model.exception.SQLConsultException;
import java.sql.Connection;
import java.util.List;

public interface IDAO<E> {
    
    public List<E> getList(Connection connection, String where) throws SQLConsultException;
    
}
