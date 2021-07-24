
package Model;

import java.time.LocalDate;



public abstract class Person extends Model {
    
    private static Person userConnected = null;
    
    protected String firstName;
    protected String lastName;
    protected String adress;
    protected String phoneNumber;
    protected LocalDate birthDate;
    protected String password;
    protected String email;
    
    public static void setUserConnected(Person user){
        Person.userConnected = user;
    }
    
    public String getPsswd(){
        return this.password;
    }
   
}
