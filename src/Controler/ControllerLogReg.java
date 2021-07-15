/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.net.URL;
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
    private DatePicker bithDate;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

   
    @FXML
    private void register(ActionEvent event) {
        label.setText("Register Failed");
    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}