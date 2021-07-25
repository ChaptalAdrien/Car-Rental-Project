package Model;

import java.sql.*;
import Conf.Conf;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Model extends Conf {
    
        private Connection conn = null;
   
    //init the connexion to the data base         
    public void init(){
        
        try {
                // db parameters - ptest is the name of the database
                String URL = this.getURL();
                String USER = this.getUSER();
                String PASSWORD = this.getPASSWORD();
                
                // create a connection to the database
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                // more processing here
                // ...   
      
        } catch(SQLException e) {
                 System.out.println(e.getMessage());
        } 
    }
    
    
    //Close the connexion to the data base
    public void close(){
        try{
            if(conn != null)
                conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
    }
    
    
    public void update(String object, String column, String primaryKey, String pkValue, String newValue){
        //init databese connection 
        this.init();
        
        try {

            String request = "update " + object + " set " + column + " = ? where " + primaryKey + " = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, pkValue);
            preparedStatement.executeUpdate();
            
 
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //close database connexion
        this.close();
        
 
        
    }
    
    
    public ResultSet select(String object, String primary_key, String value){
         
        //initdatabaseConnection
        this.init();
        
        try {

            String request = "select * from " + object + " where " + primary_key + " = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, value);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs;
 
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //close database connexion
        this.close();
        
        return null;
        
    }
    
    //Select all rows of a designated Table
    public ResultSet selectAll(String object){
        
        //initdatabaseConnection
        this.init();
        
        ResultSet rs = null;
        
        try {
            
            String request = "select * from ?";

            PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, object);
                 
            rs = preparedStatement.executeQuery();
 
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //close database connexion
        this.close();
        
        return rs;
    }
    
    //Save the data into the specified table 
    public void save(ArrayList data, String table){
        
        //init database connexion
        this.init();

        String request = "INSERT INTO " + table + " VALUES (";
        
        //Creation of the prepared update
 
        for(int i=0; i < data.size(); i++){
            if(i == data.size() - 1){
 
                request += "?);";
            }else{
             
                request += "?, ";
            }
            
        }
        
        //filling with the values and execute update
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(request);

            for(int i=0; i < data.size(); i++){
                if(data.get(i) instanceof String){
                    preparedStatement.setString(i + 1, (String) data.get(i));
                }else if(data.get(i) instanceof Double){
                    preparedStatement.setDouble(i+1, (double) data.get(i));
                }else if(data.get(i) instanceof Integer){
                    preparedStatement.setInt(i+1, (int) data.get(i));
                }
            }
            preparedStatement.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            this.close();
        }
        
        //close database connexion
        this.close();
        
    }
    
        //public ResultSet GetHistory(Customer customer){
        
    //}
    
}
    
    
