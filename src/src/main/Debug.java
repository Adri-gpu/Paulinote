/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import src.main.Reunions;

/**
 *
 * @author louis
 */
public class Debug {
    
    public static void main(String[]args){
        
        Connection connection=null;
        Statement statement=null;
        
        try{
        connection= DriverManager.getConnection("jdbc:sqlite:bdd.db");
        statement = connection.createStatement();
        
             for (int i=1;i<6;++i){
                 String sql = "DELETE FROM REUNION WHERE id_reu="+i;
                 System.out.println(sql);
                 statement.executeUpdate(sql);
                 
             }
            
            

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
        
    }
}
