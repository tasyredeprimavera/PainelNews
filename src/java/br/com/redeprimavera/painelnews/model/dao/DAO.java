package br.com.redeprimavera.painelnews.model.dao;

import br.com.redeprimavera.painelnews.model.exception.SQLCloseException;
import br.com.redeprimavera.painelnews.model.exception.SQLConsultException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<E> implements IDAO<E> {

    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public Statement getStmt() {
        return stmt;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    private void close() throws SQLCloseException {
        try {
            closeStatement();
            closePreparedStatement();
            closeResultSet();
        } catch (SQLException ex) {
            throw new SQLCloseException(ex.getMessage());
        }
    }

    private void closeStatement() throws SQLException {
        if (stmt != null ) {
            stmt.close();
        }
    }
    
    private void closePreparedStatement() throws SQLException {
        if (pstmt != null) {
            pstmt.close();
        }
    }

    private void closeResultSet() throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    @Override
    public List<E> getList(Connection connection, String sql) throws SQLConsultException {
        List<E> elements = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                elements.add(instantElementFromResultSet(connection));
            }
        } catch (SQLException ex) {
            throw new SQLConsultException(ex.getMessage());
        } finally {
            try {
                close();
            } catch (SQLCloseException ex) {
                throw new SQLConsultException(ex.getMessage());
            }
        }
        return elements;
    }

    protected abstract E instantElementFromResultSet(Connection connection) throws SQLConsultException;

}
