/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.returns.multiarrayedReturns;

/**
 *
 * @author Stevoski
 */
public class productProductionReturns {
    private String date;
    private String prodName; 
    private Double qty;
    private Integer prodId;
//    private String unik;
    public productProductionReturns(String pdate,String ppname, Double pqty,Integer ppid){
        this.date=pdate;
        this.prodName=ppname;
        this.qty=pqty;
        this.prodId=ppid;
//        this.unik=unike;
    }
    productProductionReturns(String string, String string0, double parseDouble, String string1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String getDate(){ return date;}
    public String  getprodName(){return prodName;}
    public Double getQty() {return qty;}
    public Integer getId(){return prodId;}
//    public String  getUnike(){return unik;}
}