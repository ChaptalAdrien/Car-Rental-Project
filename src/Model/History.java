/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author rouss
 */
public class History {
    
    private String car;
    private String type;
    private String rentDate;
    private String endDate;
    private double price;
    
    public History(String car, String type, String rentDate, String endDate, double price){
        this.car = car;
        this.type = type;
        this.rentDate = rentDate;
        this.endDate = endDate;
        this.price = price;
    }
}
