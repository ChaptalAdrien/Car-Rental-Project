/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;
import Model.History;
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
import javafx.scene.control.TableView;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;



public class HistoryController implements Initializable{
    @FXML
    private TableView historyTable;
    @FXML 
    private Button back;
    
    @FXML
    private TableColumn columnCar;
    
    @FXML
    private TableColumn columnType;
    
    @FXML
    private TableColumn columnRentDate;
    
    @FXML
    private TableColumn ColumnEndDate;
    
    @FXML
    private TableColumn columnPrice;
    
    @FXML
    public void ButtonBack(ActionEvent event) throws Exception {             
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       try{   
            ObservableList<History> data = Person.userConnected.GetHistory(Person.userConnected.getEmail());
            
            columnCar.setCellValueFactory(new PropertyValueFactory<>("car"));
            columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
            columnRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
            ColumnEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
            columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            

 
            // Display row data
            historyTable.setItems(data);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
        
 }  

    

