
package Model;

import java.sql.ResultSet;
import java.util.Date;




public class Car extends Model{
    
    private static String tableName = "cars";
    private static String primary_key = "idCar";
    
    private String idCar;
    private String model;
    private String carType;
    
    //CONSTRUCTORS
    public Car(String idCar, String Name, String carType) {
        this.idCar = idCar;
        this.model = Name;
        this.carType = carType;
    }
    
    public Car(){
        
    }

    //GETTERS
    public String getIdCar() {
        return idCar;
    }

    public String getModel() {
        return model;
    }

    public String getCarType() {
        return carType;
    }

    //SETTERS
    public void setLicensePlate(String licensePlate) {
        this.idCar = licensePlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
    
    //METHODS
    //return the daily price of the car
    public double getDailyPrice(){
        
        double dailyPrice = 0;
        
        switch (this.idCar) {
            case "0":
                dailyPrice = 25;
                break;
            case "1":
                dailyPrice = 70;
                break;
            case "2":
                dailyPrice = 150;
                break;
            case "3":
                dailyPrice = 500;
                break;
            default:
                break;
        }
        
        return dailyPrice;
    }
    
    //Select this car in database
    public void selectCar(String idCar){
        
        try{
        
        ResultSet rs = this.select(Car.tableName, Car.primary_key, idCar);
        
        while(rs.next()){
            this.idCar = idCar;
            this.carType = rs.getString("carType");
            this.model = rs.getString("model");
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    } 

}