/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Customer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Adrien
 */
public class ControllerLogReg implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField adress;
    @FXML
    private TextField phoneNumber;
    @FXML
    private DatePicker birthDate;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

   
    @FXML
    private void register(ActionEvent event) {
        
        int id = (int) (Math.random() * ( 100000000 - 0 ));
        String fn = this.firstName.getText();
        String ln = this.lastName.getText();
        String adr = this.adress.getText();
        String pn = this.phoneNumber.getText();
        LocalDate bd = this.birthDate.getValue();
        String em = this.email.getText();
        String pswd = this.password.getText();
        boolean m = true;
        boolean ct = false;
        
        Customer c = new Customer(id,fn,ln, pn, adr,bd,m, ct, pswd, em);
        
        c.register();
        
        label.setText("Register Failed");
    }
    
    /*
    public String hashSaltPswd(String password){
        

        MessageDigest md;
        try
        {
            // Select the message digest for the hash computation -> SHA-256
            md = MessageDigest.getInstance("SHA-256");

            // Generate the random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Passing the salt to the digest for the computation
            md.update(salt);

            // Generate the salted hash
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword)
                sb.append(String.format("%02x", b));
            
            String hashedSaltpswd= (String) sb;
            
            return hashedSaltpswd;
        } catch (NoSuchAlgorithmException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}