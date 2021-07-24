/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;
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
public class MainController implements Initializable{
    
    @FXML
    private Button members;
    @FXML
    private Button cars;
    @FXML
    private Button agencies;
    @FXML
    private Button register;
    @FXML
    private Button login;

    //Actions Login
    @FXML
    public void ButtonLogin(ActionEvent event) throws Exception {             
        try {
        Stage stage1 = (Stage) register.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/loginPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    //Actions Register
    @FXML
    public void ButtonRegister(ActionEvent event) throws Exception {             
        try {
        Stage stage1 = (Stage) register.getScene().getWindow();
        stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/registerPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
