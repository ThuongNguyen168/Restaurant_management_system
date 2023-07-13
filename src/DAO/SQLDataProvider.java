/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class SQLDataProvider {
    private Connection con;
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public Statement sta = null;
    public ResultSet rs = null;
    public PreparedStatement presta = null;
    
    public void open(){
        String strServer = "DESKTOP-MRQDE50\\SQLSERVER";
        String strDatabase = "QL_NHAHANG";
        String USER_NAME = "sa";
        String PASSWORD = "123";
        
        try {
            Class.forName(driver);
            String conURL = "jdbc:sqlserver://" + strServer + ":1433;"
                    + "databaseName=" + strDatabase + ";"
                    + "user=" + USER_NAME + ";password=" + PASSWORD;
            con = DriverManager.getConnection(conURL);
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void close()
    {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet excuteSQL(String sql)
    {
        try {
            
            sta = con.createStatement();
            rs = sta.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public int excuteUPDATE(String sql)
    {
        int n = -1;
        
        try {
            sta = con.createStatement();
            n = sta.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
