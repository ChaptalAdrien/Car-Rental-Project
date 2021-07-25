package Controler;
import Model.Car;
import Model.Customer;
import Model.CarRental;
import Model.Discount;
import Model.Person;
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
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import Model.Person.*;
import java.util.UUID;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rouss
 */
public class CarsController implements Initializable{
    @FXML
    private Button logreg;
    @FXML
    private Button pro;
    @FXML
    private Button select1;
    @FXML
    private Button select2;
    @FXML
    private Button select3;
    @FXML
    private Button select4;
    @FXML
    private Button myAccount;
    @FXML
    private Text welcome;
    @FXML
    private Label tag;

    @FXML
    public void ButtonLoginReg(ActionEvent event) throws Exception {
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
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
@FXML
    public void ButtonS1(ActionEvent event) throws Exception {
        
        Car car = new Car("0", "Dacia Sandero", "Familliale");
        Customer customer;
        String idRent = UUID.randomUUID().toString();
        
        //if nobody is connected, we set the booking to the guest
        if(Person.userConnected != null){
            customer = (Customer) Person.userConnected;
        }else{
            customer = Customer.getGuest(); 
        }
        
        CarRental cr = new CarRental(idRent, customer, car);
        CarRental.setOnGoingRent(cr);
        
        //CarRental cr = new CarRental();
        
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkOutPage.fxml"));
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
    public void ButtonS2(ActionEvent event) throws Exception {  
        
        Car car = new Car("1", "Peugeot 308", "Compacte");
        Customer customer;
        String idRent = UUID.randomUUID().toString();
        
        //if nobody is connected, we set the booking to the guest
        if(Person.userConnected != null){
            customer = (Customer) Person.userConnected;
        }else{
            customer = Customer.getGuest(); 
        }
        
        CarRental cr = new CarRental(idRent, customer, car);
        CarRental.setOnGoingRent(cr);
        
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkOutPage.fxml"));
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
    public void ButtonS3(ActionEvent event) throws Exception { 
        
        Car car = new Car("2", "Mercedes 4x4", "4x4");
        Customer customer;
        String idRent = UUID.randomUUID().toString();
        
        //if nobody is connected, we set the booking to the guest
        if(Person.userConnected != null){
            customer = (Customer) Person.userConnected;
        }else{
            customer = Customer.getGuest(); 
        }
        
        CarRental cr = new CarRental(idRent, customer, car);
        CarRental.setOnGoingRent(cr);
        
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkOutPage.fxml"));
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
    public void ButtonS4(ActionEvent event) throws Exception {
        
        Car car = new Car("3", "Rolls Royce Ghost", "Luxe");
        Customer customer;
        String idRent = UUID.randomUUID().toString();
        
        //if nobody is connected, we set the booking to the guest
        if(Person.userConnected != null){
            customer = (Customer) Person.userConnected;
        }else{
            customer = Customer.getGuest(); 
        }
        
        CarRental cr = new CarRental(idRent, customer, car);
        CarRental.setOnGoingRent(cr);
        
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkOutPage.fxml"));
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
    public void ButtonMyAccount(ActionEvent event) throws Exception{
        if (Model.Person.userConnected != null){
           try {
            Stage stage1 = (Stage) logreg.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/myAccount.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);   
                stage.show();
            }catch(Exception e) {
                e.printStackTrace();
          } 
        }
    }
@FXML
    public void ButtonPro(ActionEvent event) throws Exception {             
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Model.Person.userConnected != null){
            if (logreg.isVisible()){logreg.setVisible(false);}        
            if (!welcome.isVisible()){welcome.setVisible(true);}
            if (!tag.isVisible()){
                tag.setVisible(true);
                tag.setText(Model.Person.userConnected.getFirstName());
            }
            if (!myAccount.isVisible()){myAccount.setVisible(true);}
        }else {
            if (myAccount.isVisible()){myAccount.setVisible(false);}
            if (!logreg.isVisible()){logreg.setVisible(true);}
            if (welcome.isVisible()){welcome.setVisible(false);}
            if (!tag.isVisible()){tag.setVisible(false);}
        }
    }

}
