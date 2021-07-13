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
public class Rawmaterial {
    private String materialname;
    private Double quantity;
    private Double price;
   private String unit;
    public Rawmaterial(String rname, Double rqty, String runit, Double rprice){
        this.materialname=rname;
        this.quantity=rqty;
        this.unit=runit;
        this.price=rprice;
        
    }

    Rawmaterial(String string, String string0, double parseDouble, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getrName(){return materialname;}
    public Double getrPrice(){return price;}
    public Double getrQuantity(){return quantity;}
   public String getrUnit(){return unit;}
    
}
