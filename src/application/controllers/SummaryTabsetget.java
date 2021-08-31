package application.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class SummaryTabsetget {
	@FXML private SimpleStringProperty sumdate;
	@FXML private SimpleStringProperty sumprod;
	@FXML private SimpleDoubleProperty sumqty;
	@FXML private SimpleStringProperty sumfact;
	@FXML private SimpleDoubleProperty sumcost;
	@FXML private SimpleDoubleProperty sumsell;
	@FXML private SimpleDoubleProperty sumprofit;
	public SummaryTabsetget(String sumdate, String sumfact,String sumprod, Double sumqty,Double sumcost,Double sumsell,Double sumprofit) {
		super();
		this.sumdate = new SimpleStringProperty(sumdate);
		this.sumfact = new SimpleStringProperty(sumfact);
		this.sumprod = new SimpleStringProperty(sumprod);
		this.sumqty = new SimpleDoubleProperty(sumqty);
	this.sumcost=new SimpleDoubleProperty(sumcost);
		this.sumsell =  new SimpleDoubleProperty(sumsell);
		this.sumprofit =  new SimpleDoubleProperty(sumprofit);		
	}
	public String getSumdate() {
		return sumdate.get();
	}
	public void setSumdate(SimpleStringProperty sumdate) {
		this.sumdate = sumdate;
	}
	public String getSumprod() {
		return sumprod.get();
	}
	public void setSumprod(SimpleStringProperty sumprod) {
		this.sumprod = sumprod;
	}
	public Double getSumqty() {
		return sumqty.get();
	}
	public void setSumqty(SimpleDoubleProperty sumqty) {
		this.sumqty = sumqty;
	}
	public String getSumfact() {
		return sumfact.get();
	}
	public void setSumfact(SimpleStringProperty sumfact) {
		this.sumfact = sumfact;
	}
	public Double getSumcost() {
		return sumcost.get();
	}
	public void setSumcost(SimpleDoubleProperty sumcost) {
		this.sumcost = sumcost;
	}
	public Double getSumsell() {
		return sumsell.get();
	}
	public void setSumsell(SimpleDoubleProperty sumsell) {
		this.sumsell = sumsell;
	}
	public Double getSumprofit() {
		return sumprofit.get();
	}
	public void setSumprofit(SimpleDoubleProperty sumprofit) {
		this.sumprofit = sumprofit;
	}
}
