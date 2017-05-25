/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coaextraction;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author User
 */
public class DatabaseManager {
    private Connection dConntion;
    public DatabaseManager() {
        dConntion = null;
    }
    
    public  Connection makeConnection() throws SQLException {
        if (dConntion == null) {
            new Driver();
            dConntion = DriverManager.getConnection("jdbc:mysql://localhost:3306/coa", "root", "");
        }
        return dConntion;
    }
    
    public void insert(List<String> values) throws SQLException {
        String query = " insert into recommendation(Action, Actuator, Object, Example)" 
                + " values (?,?,?,?)";
        PreparedStatement preparedStmt = null;
        preparedStmt = dConntion.prepareStatement(query);
        preparedStmt.setString(1, values.get(0));
        preparedStmt.setString(2, values.get(1));
        preparedStmt.setString(3, values.get(2));
        preparedStmt.setString(4, values.get(3));
        System.out.println(preparedStmt);
        preparedStmt.execute();
    }
    
    public ResultSet queryAll() throws SQLException {
        String query = "SELECT * FROM recommendation";
        Statement st = dConntion.createStatement();
        return st.executeQuery(query);
    }
    
    public ResultSet queryByAA(String action, String actuator) throws SQLException {
        String query = "SELECT * FROM recommendation ";
        if((action != null && !action.isEmpty()) || (actuator != null && !actuator.isEmpty())) {
            query += "WHERE ";
        }
        if(action != null && !action.isEmpty()) {
            query += "Action LIKE '" + action.toLowerCase() + "' ";
        }
        if(actuator != null && !actuator.isEmpty()) {
            if(action != null && !action.isEmpty()) {
                query += "AND ";
            }
            query += "Actuator LIKE '" + actuator.toLowerCase() + "'";
        }
        System.out.println(query);
        Statement st = dConntion.createStatement();
        return st.executeQuery(query);
    }
    
    public void closeConnection() throws SQLException {
        dConntion.close();
        dConntion = null;
    }
}
