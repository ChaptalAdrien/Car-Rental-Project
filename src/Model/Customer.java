
package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class Customer extends Person {
    
    private static String tableName = "customers";
    
    private int idCustomer;
    private boolean member;
    private boolean customerType; //0 is particular, 1 is business
    private String Password; // Always hash + seed 

    public Customer(int idCustomer, String firstName, String lastName, String phoneNumber, String adress, LocalDate birthDate, boolean member, boolean customerType, String Password, String email) {
        
        this.idCustomer = idCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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
        data.add(this.phoneNumber);
        data.add(this.adress);
        data.add(this.birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        int m = this.member ? 1 : 0;
        data.add(m);
        int ct = this.customerType ? 1 : 0;
        data.add(ct);
        data.add(this.Password);
        data.add(this.email);
        
        this.Save(data, Customer.tableName);
        
    }
    
}
