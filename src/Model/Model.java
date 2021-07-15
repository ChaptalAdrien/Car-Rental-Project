package Model;

import java.sql.*;
import Conf.Conf;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Model extends Conf {
    
        private static Connection conn = null;
   
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
    
    //Select all rows of a designated Table
    public ResultSet selectAll(String object){
        
        ResultSet rs = null;
        
        try {
            
            String request = "select * from ?";

            PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, object);
                 
            rs = preparedStatement.executeQuery();
 
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //Save the data into the specified table 
    public void Save(ArrayList data, String table){
        
        //Putting all values into a string 
        String values = "(";
        
        for(int i=0; i < data.size(); i++){
            if(i == data.size() - 1){
                values += "'" + data.get(i) + "'" + ");";
            }else{
                values += "'" + data.get(i) + "'";
            }
        }
        
        try {
            
            String request = "INSERT INTO ? VALUES ?";

            PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, table);
            preparedStatement.setString(2,values);
                 
            preparedStatement.executeQuery();
 
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
    
    
