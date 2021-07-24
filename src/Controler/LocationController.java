/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;
//import Controler.Main;
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
public class LocationController implements Initializable{

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
    private Label emailDisplay;

    //Page Checkout
    @FXML
    private Label promptSelection;


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
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkoutPage.fxml"));
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
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkoutPage.fxml"));
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
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkoutPage.fxml"));
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
        try {
        Stage stage1 = (Stage) logreg.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/checkoutPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    

    //MAIN
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
}
