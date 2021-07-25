/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Customer;
import Conf.Security;
import Model.Person.*;

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
    @FXML
    private Button displayMyData;

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
    private PasswordField newPassword;
    @FXML
    private Button back;
    @FXML
    private Button loginButton;
    @FXML
    private Button hisotry;
    @FXML
    private Button registerButton;

    //Login
    @FXML
    private TextField login;
    @FXML
    private Button logIn;
    @FXML
    private Label fnStatus;
    @FXML
    private Label lnStatus;
    @FXML
    private Label adStatus;
    @FXML
    private Label pnStatus;
    @FXML
    private Label pwdStatus;


    //Event
    @FXML
    private void register(ActionEvent event) throws Exception {
        try{
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
        try {
        Stage stage1 = (Stage) back.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/carsPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setResizable(false); 
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
        
        }   catch(Exception e) {
            //label.setText("Register Failed");
        }
    }
    
    @FXML
    public void login(ActionEvent event) throws Exception {             
        
        String email = this.login.getText();
        String password = Security.hashSaltPswd(this.password.getText());
        
        Customer c = new Customer();
        c.login(email, password);
        try {
        Stage stage1 = (Stage) back.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/carsPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1)); 
                stage.setResizable(false); 
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
         
    }
        
            
    
    //Action button Back
    @FXML
    public void ButtonBack(ActionEvent event) throws Exception {             
        try {
        Stage stage1 = (Stage) back.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/mainPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setResizable(false); 
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
    public void ButtonChangePwd(ActionEvent event) throws Exception{
        try{
            if (firstName.getText() == null || firstName.getText().trim().isEmpty()){
                fnStatus.setText("");
            } else {
                Model.Person.userConnected.update(Customer.tableName, "firstName", Customer.primary_key, Model.Person.userConnected.getEmail(), firstName.getText());
                fnStatus.setText("First Name Changed");
            }
            if (lastName.getText() == null || lastName.getText().trim().isEmpty()){
                lnStatus.setText("");
            } else {
                Model.Person.userConnected.update(Customer.tableName, "lastName", Customer.primary_key, Model.Person.userConnected.getEmail(), lastName.getText());
                lnStatus.setText("Last Name Changed");
            }
            if (adress.getText() == null || adress.getText().trim().isEmpty()){
                adStatus.setText("");
            } else {
                Model.Person.userConnected.update(Customer.tableName, "adress", Customer.primary_key, Model.Person.userConnected.getEmail(), adress.getText());
                adStatus.setText("Adress Changed");
            }
            if (phoneNumber.getText() == null || phoneNumber.getText().trim().isEmpty()){
                pnStatus.setText("");
            } else {
                Model.Person.userConnected.update(Customer.tableName, "phoneNumber", Customer.primary_key, Model.Person.userConnected.getEmail(), phoneNumber.getText());
                pnStatus.setText("Phone Changed");
            }
            if (newPassword.getText() == null || newPassword.getText().trim().isEmpty()){
                pwdStatus.setText("");
            } else {
                String nPassword = Security.hashSaltPswd(this.newPassword.getText());
                Model.Person.userConnected.update(Customer.tableName, "password", Customer.primary_key, Model.Person.userConnected.getEmail(), nPassword);
                pwdStatus.setText("Phone Changed");
            }
        } catch(Exception e){
            e.printStackTrace();
            pwdStatus.setText("Something happened"); 
            }
    }     

    public void ButtonDisplayData(ActionEvent event) throws Exception{
    }

    public void ButtonHistory(ActionEvent event) throws Exception{
        try {
        Stage stage1 = (Stage) back.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/HistoryPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setResizable(false); 
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstName.setPromptText(Model.Person.userConnected.getFirstName());
        lastName.setPromptText(Model.Person.userConnected.getLastName());
        adress.setPromptText(Model.Person.userConnected.getAdress());
        phoneNumber.setPromptText(Model.Person.userConnected.getPhoneNumber());
        birthDate.setValue(Model.Person.userConnected.getBirthDate());
    }    
    
}