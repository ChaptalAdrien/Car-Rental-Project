
package Conf;


import java.sql.*;

public abstract class Conf {
    
    private static final String URL       = "jdbc:mysql://localhost:3306/rentalcars";
    private static final String USER      = "root";
    private static final String PASSWORD  = "";
  

    protected static String getURL() {
        return URL;
    }

    protected static String getUSER() {
        return USER;
    }

    protected static String getPASSWORD() {
        return PASSWORD;
    }
    
    
    /*
    public void connexion(){
        // TODO code application logic here //coucou
        Connection conn = null;
        try {
                // db parameters - ptest is the name of the database

                // create a connection to the database
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                // more processing here
                // ...   
                
                
                Statement stmt=conn.createStatement(); 
                ResultSet rs=stmt.executeQuery("select * from customers"); 
                while(rs.next()) 
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)); 
             
            } catch(SQLException e) {
                 System.out.println(e.getMessage());
            } finally {
                 try{
                         if(conn != null)
                         conn.close();
                     }catch(SQLException ex){
                            System.out.println(ex.getMessage());
                    }
        } 
    }
    
    */
    
}

