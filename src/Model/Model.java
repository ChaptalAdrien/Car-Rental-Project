package Model;

import java.sql.*;
import Conf.Conf;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Model extends Conf {
    
        private static Connection conn = null;
        
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
    
    public void close(){
        try{
            if(conn != null)
                conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
    }
    
    public ArrayList<Object> selectAll(String object){
        
        ArrayList<Object> Data = new ArrayList();
        
        try {
            
            String request = "select * from ?";

            PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, object);
                 
            ResultSet rs = preparedStatement.executeQuery();
 
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Data;
    }
    
    
    
}
    
    
