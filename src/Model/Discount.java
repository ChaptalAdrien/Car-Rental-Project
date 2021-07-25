
package Model;

import java.util.Date;


public class Discount {
    
    private String idDiscount;
    private int percentage;
    private Date validityDate;
    private String Name;
    
    public Discount(String idDiscount){
        this.idDiscount = idDiscount;
    }
    
    public String getIdDiscount(){
        
        return this.idDiscount;
    }
    
}
