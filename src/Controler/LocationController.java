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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *
 * @author rouss
 */
public class LocationController implements Initializable {

    //Button
    @FXML
    private Button bookAcar;
    @FXML
    private Button logreg;
    @FXML
    private Button pro;
    @FXML
    private Button next;

    //TextField
    //Combo Box
    @FXML
    private ComboBox comboAgency;


    //Actions Button Book A Car
    @FXML
    public void ButtonNext(ActionEvent event){
        
}

    //MAIN
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
}
