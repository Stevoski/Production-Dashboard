package application.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class ExpenseTabsetget {

	@FXML private SimpleStringProperty expdate;
	@FXML private SimpleStringProperty expfact;
	@FXML private SimpleStringProperty expprod;
	@FXML private SimpleDoubleProperty expqty;
	@FXML private SimpleDoubleProperty expraw;
	@FXML private SimpleDoubleProperty expack;
	@FXML private SimpleDoubleProperty expman;
	@FXML private SimpleDoubleProperty expboil;
	@FXML private SimpleDoubleProperty expel;
	@FXML private SimpleDoubleProperty expexc;
	@FXML private SimpleDoubleProperty expwat;
	@FXML private SimpleDoubleProperty expamt;
	@FXML private SimpleDoubleProperty expcost;
	
	public ExpenseTabsetget (String expdate,String expfact,String expprod, Double expqty,Double expraw,Double expack, Double expman, 
			Double expboil, Double expel,Double expwat, Double expexc,Double expamt,Double expcost ) {
		
		this.expdate = new SimpleStringProperty(expdate);
		this.expfact = new SimpleStringProperty(expfact);
		this.expprod = new SimpleStringProperty(expprod);
		this.expqty = new SimpleDoubleProperty(expqty);
	this.expraw=new SimpleDoubleProperty(expraw);
		this.expack =  new SimpleDoubleProperty(expack);
		this.expman =  new SimpleDoubleProperty(expman);
		this.expboil =  new SimpleDoubleProperty(expboil);
		this.expel =  new SimpleDoubleProperty(expel);
		this.expexc =  new SimpleDoubleProperty(expexc);
		this.expwat =  new SimpleDoubleProperty(expwat);
		this.expamt =  new SimpleDoubleProperty(expamt);
		this.expcost =  new SimpleDoubleProperty(expcost);
	}
	public String getExpdate() {
		return expdate.get();
	}
	public void setExpdate(SimpleStringProperty expdate) {
		this.expdate = expdate;
	}
	public String getExpfact() {
		return expfact.get();
	}
	public void setExpfact(SimpleStringProperty expfact) {
		this.expfact = expfact;
	}
	public String getExpprod() {
		return expprod.get();
	}
	public void setExpprod(SimpleStringProperty expprod) {
		this.expprod = expprod;
	}
	public Double getExpqty() {
		return expqty.get();
	}
	public void setExpqty(SimpleDoubleProperty expqty) {
		this.expqty = expqty;
	}
	public Double getExpraw() {
		return expraw.get();
	}
	public void setExpraw(SimpleDoubleProperty expraw) {
		this.expraw = expraw;
	}
	public Double getExpack() {
		return expack.get();
	}
	public void setExpack(SimpleDoubleProperty expack) {
		this.expack = expack;
	}
	public Double getExpman() {
		return expman.get();
	}
	public void setExpman(SimpleDoubleProperty expman) {
		this.expman = expman;
	}
	public Double getExpboil() {
		return expboil.get();
	}
	public void setExppboil(SimpleDoubleProperty expboil) {
		this.expboil = expboil;
	}
	public Double getExpel() {
		return expel.get();
	}
	public void setExpel(SimpleDoubleProperty expel) {
		this.expel = expel;
	}
	public Double getExpexc() {
		return expexc.get();
	}
	public void setExpexc(SimpleDoubleProperty expexc) {
		this.expexc = expexc;
	}
	public Double getExpamt() {
		return expamt.get();
	}
	public void setExpamt(SimpleDoubleProperty expamt) {
		this.expamt = expamt;
	}
	public Double getExpcost() {
		return expcost.get();
	}
	public void setExpcost(SimpleDoubleProperty expcost) {
		this.expcost = expcost;
	}
	public Double getExpwat() {
		return expwat.get();
	}
	public void setExpwat(SimpleDoubleProperty expwat) {
		this.expwat = expwat;
	}
}
