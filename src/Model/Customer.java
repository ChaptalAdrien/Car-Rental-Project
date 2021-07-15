
package Model;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person {
    
    private static String tableName = "customers";
    
    private int idCustomer;
    private boolean member;
    private boolean customerType; //0 is particular, 1 is business
    private String Password; // Always hash + seed 

    public Customer(int idCustomer, String firstName, String lastName, String adress, Date birthDate, boolean member, boolean customerType, String Password, String email) {
        
        this.idCustomer = idCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.birthDate = birthDate;
        this.member = member;
        this.customerType = customerType;
        this.Password = Password; // Always hash + seed 
        this.email = email;
    
    }
    

    
    //Save the custommer data into an arraylist, then save it into the database
    public void register(){
        
        ArrayList data = new ArrayList();
        data.add(this.idCustomer);
        data.add(this.firstName);
        data.add(this.lastName);
        data.add(this.adress);
        data.add(this.birthDate);
        data.add(this.member);
        data.add(this.customerType);
        data.add(this.Password);
        data.add(this.email);
        
        this.Save(data, Customer.tableName);
        
    }
    
}
