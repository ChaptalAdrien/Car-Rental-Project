/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;
//import Controler.Main;

import Model.Car;
import Model.Customer;
import Model.CarRental;
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
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import Model.Person.*;
import java.util.UUID;


/**
 *
 * @author rouss
 */
public class RentController implements Initializable{

    //Button
    @FXML
    private Button bookAcar;
    @FXML
    private Button logreg;
    @FXML
    private Button pro;
    @FXML
    private Button next;
    @FXML
    private Button select1;
    @FXML
    private Button select2;
    @FXML
    private Button select3;
    @FXML
    private Button select4;
    @FXML 
    private Label emailDisplay;
    @FXML 
    private Label userStatus;


    //Page Checkout
    @FXML
    private Label prompt;
    @FXML
    private Button back;
    @FXML
    private Label PayementStatus;
    @FXML
    private TextField nameOnCard;
    @FXML
    private TextField cardNumber;
    @FXML
    private DatePicker expDate;
    @FXML
    private TextField ccv;
    @FXML
    private Button myAccount;
    @FXML
    private DatePicker rentalDate;
    @FXML
    private DatePicker returnDate;
    @FXML
    private Label totalPrice;




    //Actions Button Book A Car
    @FXML
    public void ButtonBookCar(ActionEvent event) throws Exception {           
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/carsPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }

    //Actions Login
    @FXML
    public void ButtonLoginReg(ActionEvent event) throws Exception {
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/mainPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    //Actions Pro
    @FXML
    public void ButtonPro(ActionEvent event) throws Exception {             
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/mainPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    //Cars selection
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
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    //CHECKOUT
    @FXML
    public void Back(ActionEvent event) throws Exception {             
        try {
        Stage stage1 = (Stage) back.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/carsPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    public void ProceedGuest(ActionEvent event) throws Exception {
        //String name = nameOnCard.getText();
        //String cnum = cardNumber.getText();
        //LocalDate expdate = expDate.getValue();
        //String code = CCV.getText();
        if ((nameOnCard.getText() == null || nameOnCard.getText().trim().isEmpty()) || (cardNumber.getText() == null || cardNumber.getText().trim().isEmpty()) || (ccv.getText() == null || ccv.getText().trim().isEmpty()) || (expDate.getValue() == null)){
            PayementStatus.setText("Wrong");
        }else{
            PayementStatus.setText("ALL GOOD !");
        }
    }   

    public void ButtonMyAccount(ActionEvent event) throws Exception{
        if (Model.Person.userConnected != null){
           try {
            Stage stage1 = (Stage) logreg.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/myAccount.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
            }catch(Exception e) {
                e.printStackTrace();
          } 
        }else{
                userStatus.setText("Not connected !");
            }
    }


    //MAIN
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
}

 
