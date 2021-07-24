/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Customer;
import Conf.Security;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.DatePicker;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.io.IOException;

/**
 *
 * @author rouss
 */
public class LogRegController implements Initializable {
    
    //Display
    @FXML
    private Label label;

    //Register
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
    private Button backToMainButton;
    @FXML
    private Button loginButton;

    //Login
    @FXML
    private TextField login;
    @FXML
    private Button logIn;

    //Event
    @FXML
    private void register(ActionEvent event) throws Exception {
        
        String fn = this.firstName.getText();
        String ln = this.lastName.getText();
        String adr = this.adress.getText();
        String pn = this.phoneNumber.getText();
        LocalDate bd = this.birthDate.getValue();
        String em = this.email.getText();
        String pswd = Security.hashSaltPswd(this.password.getText());
        boolean m = true;
        boolean ct = false;
        
        Customer c = new Customer(em,fn,ln, pn, adr,bd,m, ct, pswd);
        
        c.register();
        
        //label.setText("Register Failed");
    }
    
    @FXML
    public void login(ActionEvent event) throws Exception {             
        
        String email = this.logIn.getText();
        String password = Security.hashSaltPswd(this.password.getText());
            
    }
    
    //Action button Back
    @FXML
    public void ButtonBack(ActionEvent event) throws Exception {             
        Stage stage = (Stage) backToMainButton.getScene().getWindow();
         // do what you have to do
        stage.close();
    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}