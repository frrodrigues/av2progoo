package br.mb.tutorialJdbcsSwingMysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao {
    public Connection connection;

    protected GenericDao() {
        this.connection = ConnectionDataBase.getConnection();
    }

    protected Connection getConnection() {
        return connection;
    }

    protected void save(String insertSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
			getConnection().prepareStatement(insertSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
			getConnection().prepareStatement(updateSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }
        pstmt.setObject(parametros.length + 1, id);
        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    protected void delete(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
			getConnection().prepareStatement(deleteSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        connection.close();
    }
}