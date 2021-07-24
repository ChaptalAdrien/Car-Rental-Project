
package Model;

import java.time.LocalDate;



public abstract class Person extends Model {
    
    public static Person userConnected = null;
    
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

    public static Person getUserConnected() {
        return userConnected;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    

}
