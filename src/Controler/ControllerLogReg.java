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
import java.time.Instant;
import java.util.Date;
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
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField adressTF;
    @FXML
    private TextField phoneNumberTF;
    @FXML
    private DatePicker bithDateDP;
    @FXML
    private TextField emailTF;
    @FXML
    private PasswordField passwordPF;

   
    @FXML
    private void register(ActionEvent event) {
        
        int id = (int) (Math.random() * ( 100000000 - 0 ));
        String firstName = this.firstNameTF.getText();
        String lastName = this.lastNameTF.getText();
        String adress = this.adressTF.getText();
        String phoneNumberTF = this.phoneNumberTF.getText();
        Date birthDate = Date.from(Instant.MIN);
        String email = this.emailTF.getText();
        String Password = this.passwordPF.getText();
        boolean member = true;
        boolean customerType = false;
        
        Customer c = new Customer(id,firstName,lastName, adress,birthDate,member, customerType, Password, email);
        
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