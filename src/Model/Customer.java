
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.security.auth.login.FailedLoginException;



public class Customer extends Person {
    
    private static String tableName = "customers";
    private static String primary_key = "email";
    
    private boolean member;
    private boolean customerType; //0 is particular, 1 is business

    
    public Customer(){
        
    }
    
    public Customer(String email, String firstName, String lastName, String phoneNumber, String adress, LocalDate birthDate, boolean member, boolean customerType, String password) {
        

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.birthDate = birthDate;
        this.member = member;
        this.customerType = customerType;
        this.password = password; // Always hash + seed 
        this.email = email;

    
    }
    

    
    //Save the custommer data into an arraylist, then save it into the database
    public void register() throws SQLException{
        
        ArrayList data = new ArrayList();
        data.add(this.email);
        data.add(this.firstName);
        data.add(this.lastName);
        data.add(this.phoneNumber);
        data.add(this.adress);
        data.add(this.birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        int m = this.member ? 1 : 0;
        data.add(m);
        int ct = this.customerType ? 1 : 0;
        data.add(ct);
        data.add(this.password);
        
        try{
            this.Save(data, Customer.tableName);
        }catch(Exception e){
             //throw new exception();    
        }
    }
    
    //Search user based on email (id) then verify if the password is the same if the user exist
    public void login(String email, String psswd) throws SQLException, FailedLoginException{
        ResultSet rs = this.select(Customer.tableName, Customer.primary_key, email);
        
        if(rs != null){
            while(rs.next()){
                this.email = email;
                this.firstName = rs.getString("firstName");
                this.lastName = rs.getString("lastName");
                this.phoneNumber = rs.getString("phoneNumber");
                this.adress = rs.getString("adress");
                
                //formating the String date to LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String date = rs.getString("birthDate");
                this.birthDate = LocalDate.parse(date, formatter);
                 
                this.member = (boolean) rs.getObject("member");
                this.customerType = (boolean) rs.getObject("customerType");
                this.password = rs.getString("password");
                
                
            }
        }else{
            throw new FailedLoginException("no user with that email");
        }
        
        //comparing passwords 
        if(!this.password.equals(psswd)){
            throw new FailedLoginException("Wrong password");
        }else{
            //If the passwords are the same, we set attributes with the db data then put set up connected user
                //setting the curent custommer to the connected user
                Person.setUserConnected(this);
            
        }
        

    }

    public static String getTableName() {
        return tableName;
    }

    public static String getPrimary_key() {
        return primary_key;
    }

    public boolean isMember() {
        return member;
    }

    public boolean isCustomerType() {
        return customerType;
    }
 
}
