package Model;

import java.sql.*;
import Conf.Conf;

public class Model extends Conf {
    
    public void init(){
        Connection conn = null;
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
}
    
    
