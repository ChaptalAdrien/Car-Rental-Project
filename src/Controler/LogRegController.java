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
import javax.security.auth.login.FailedLoginException;

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
    @FXML
    private Label loginError;

    //My Account
    @FXML
    private TextField fn;
    @FXML
    private TextField ln;
    @FXML
    private TextField ad;
    @FXML
    private TextField pn;
    @FXML
    private DatePicker bd;


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
        
        try{
        
            String email = this.login.getText();
            String password = Security.hashSaltPswd(this.password.getText());

            Customer c = new Customer();
            c.login(email, password);
        
        }catch(Exception e){
            loginError.setText("Wrong Password / Email - Try Again !");
            Thread.sleep(2000);
        }
        
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
    @FXML
    public void ButtonBackAccount(ActionEvent event) throws Exception {             
        try {
        Stage stage1 = (Stage) back.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/myAccount.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setResizable(false); 
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
    @FXML
    public void ButtonChangePwd(ActionEvent event) throws Exception{
        try{
            if (fn.getText() == null || fn.getText().trim().isEmpty()){
                fnStatus.setText("");
            } else {
                Model.Person.userConnected.update(Customer.tableName, "firstName", Customer.primary_key, Model.Person.userConnected.getEmail(), fn.getText());
                fnStatus.setText("First Name Changed");
                Model.Person.userConnected.setFirstName(fn.getText());
            }
            if (ln.getText() == null || ln.getText().trim().isEmpty()){
                lnStatus.setText("");
                
            } else {
                Model.Person.userConnected.update(Customer.tableName, "lastName", Customer.primary_key, Model.Person.userConnected.getEmail(), ln.getText());
                lnStatus.setText("Last Name Changed");
                Model.Person.userConnected.setLastName(ln.getText());
            }
            if (ad.getText() == null || ad.getText().trim().isEmpty()){
                adStatus.setText("");
            } else {
                Model.Person.userConnected.update(Customer.tableName, "adress", Customer.primary_key, Model.Person.userConnected.getEmail(), ad.getText());
                adStatus.setText("Adress Changed");
                Model.Person.userConnected.setAdress(ad.getText());
            }
            if (pn.getText() == null || pn.getText().trim().isEmpty()){
                pnStatus.setText("");
            } else {
                Model.Person.userConnected.update(Customer.tableName, "phoneNumber", Customer.primary_key, Model.Person.userConnected.getEmail(), pn.getText());
                pnStatus.setText("Phone Changed");
                Model.Person.userConnected.setPhoneNumber(pn.getText());
            }
            if (newPassword.getText() == null || newPassword.getText().trim().isEmpty()){
                pwdStatus.setText("");
            } else {
                String nPassword = Security.hashSaltPswd(this.newPassword.getText());
                Model.Person.userConnected.update(Customer.tableName, "password", Customer.primary_key, Model.Person.userConnected.getEmail(), nPassword);
                pwdStatus.setText("Password Changed");
            }
        } catch(Exception e){
            e.printStackTrace();
            pwdStatus.setText("Something happened - Impossible to modify your data"); 
            }
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
        if(Model.Person.userConnected != null){
            fn.setPromptText(Model.Person.userConnected.getFirstName());
            ln.setPromptText(Model.Person.userConnected.getLastName());
            ad.setPromptText(Model.Person.userConnected.getAdress());
            pn.setPromptText(Model.Person.userConnected.getPhoneNumber());
            bd.setValue(Model.Person.userConnected.getBirthDate());

        }
        
    }    
    
}