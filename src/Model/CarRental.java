
package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class CarRental extends Model{
    
    public static CarRental onGoingRent = null;
    
    private static String tableName = "carrental";
    private static String primary_key = "idRental";
    
    private String idRental;        
    private Customer custommer;
    private Car car;
    private Discount discount;
    private LocalDate  rentalDate;
    private LocalDate returnDate;
    private Double price;

    
    
    //Constructors
    public CarRental(String idRental, Customer custommer, Car car, Discount discount, LocalDate rentalDate, LocalDate returnDate, double price) {
        
        this.idRental = idRental;
        this.custommer = custommer;
        this.car = car;
        this.discount = discount;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.price = price;

    }
    
    public CarRental(String idRental, Customer custommer, Car car){
        
        this.idRental= idRental;
        this.custommer = custommer;
        this.car = car;
    }

    //GETTERS

    public Customer getCustommer() {
        return custommer;
    }

    public Car getCar() {
        return car;
    }

    public Discount getDiscount() {
        return discount;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Double getPrice() {
        return price;
    }

    //SETTERS
    
    public void setPrice(Double price) {
        this.price = price;
    }


    public void setCustommer(Customer custommer) {
        this.custommer = custommer;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    //Static setter for ongoin rent
    
    public static void setOnGoingRent(CarRental cr){
        CarRental.onGoingRent = cr;
    }
    
    //Methods 
    
    public void saveBooking(){
        
        ArrayList data = new ArrayList();
        
        data.add(this.idRental);
        data.add(this.car.getIdCar());
        data.add(this.discount.getIdDiscount());
        data.add(this.custommer.getEmail());
        
        data.add(this.rentalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        data.add(this.returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        data.add(this.price);
        
        this.save(data, CarRental.tableName);
        
        
    }
    

}