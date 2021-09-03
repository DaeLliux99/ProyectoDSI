/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.conexion;

import java.sql.*;

/**
 *
 * @author esteban
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://ulqvpqdnxr7mt9ia:mH2YF9FEKsSAtZiFRAN6@bmqfp6bpolelpcuxwq4j-mysql.services.clever-cloud.com:3306/bmqfp6bpolelpcuxwq4j";
    private static final String JDBC_USER = "ulqvpqdnxr7mt9ia";
    private static final String JDBC_PASSWORD = "mH2YF9FEKsSAtZiFRAN6";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}   
