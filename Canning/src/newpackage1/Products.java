/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

/**
 *
 * @author Stevoski
 */
public class Products {
    
    private String productname;
    private Double quantity;
      private String unit;
    private Double price;
 
    public Products(String pname, Double pqty, String punit, Double pprice){
        this.productname=pname;
        this.quantity=pqty;
        this.unit=punit;
        this.price=pprice;
        
    }

    Products(String string, String string0, double parseDouble, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getName(){return productname;}
    public Double getPrice(){return price;}
    public Double getQuantity(){return quantity;}
   public String getUnit(){return unit;}
}
