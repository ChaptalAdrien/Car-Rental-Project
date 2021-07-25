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
    @FXML
    private Label dateStatus;

    //RESA CONFIRMED
    @FXML
    private Button backCars;
    
    //CARS
    @FXML
    private Text welcome;
    @FXML
    private Label tag;



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
                stage.setResizable(false);  
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
                stage.setResizable(false);   
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
                stage.setResizable(false);  
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
                stage.setResizable(false);   
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    @FXML
    public void ProceedGuest(ActionEvent event) throws Exception {
        //String name = nameOnCard.getText();
        //String cnum = cardNumber.getText();
        //LocalDate expdate = expDate.getValue();
        //String code = CCV.getText();
        if ((nameOnCard.getText() == null || nameOnCard.getText().trim().isEmpty()) || (cardNumber.getText() == null || cardNumber.getText().trim().isEmpty()) || (ccv.getText() == null || ccv.getText().trim().isEmpty()) || (expDate.getValue() == null)){
            PayementStatus.setText("Wrong informations");
        }else{
            
            CarRental.onGoingRent.setRentalDate(rentalDate.getValue());
            CarRental.onGoingRent.setReturnDate(returnDate.getValue());
            Discount discount = new Discount("0");
            CarRental.onGoingRent.setDiscount(discount);
            CarRental.onGoingRent.setPrice(Double.parseDouble(totalPrice.getText()));
            
            try{
                CarRental.onGoingRent.saveBooking();
                //The rent is complete go back to null
                CarRental.onGoingRent = null;
            }catch(Exception e){
                e.printStackTrace();
            }
            
            //REDIRECTION
            try {
            Stage stage1 = (Stage) back.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/resaConfirmed.fxml"));
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
    public void DateFrom(ActionEvent event) throws Exception{
        returnDate.setVisible(true);
    }
    @FXML
    public void DateTo(ActionEvent event) throws Exception{
        //Get the Daily Price
        Double dailyPrice = CarRental.onGoingRent.getCar().getDailyPrice();
        //Get the date and then parse them
        LocalDate rentDate = rentalDate.getValue();
        LocalDate retDate = returnDate.getValue();
        long noOfDaysBetween = ChronoUnit.DAYS.between(rentDate, retDate);
        if (noOfDaysBetween > 0){
            double tprice = (noOfDaysBetween*dailyPrice);
            String str = String.valueOf(tprice);
            totalPrice.setText(str);
        }else{
            dateStatus.setText("Please select valid dates");
        }
        
    }

    //RESA
    @FXML
    public void ButtonBackCars(ActionEvent event) throws Exception{
        try {
            Stage stage1 = (Stage) backCars.getScene().getWindow();
            stage1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/carsPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);   
                stage.show();
            }catch(Exception e) {
                e.printStackTrace();
          } 
    }
    //MAIN
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
