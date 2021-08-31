package application.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class CostTabsetget {

	@FXML private SimpleStringProperty cosdate;
	@FXML private SimpleStringProperty cosfact;
	@FXML private SimpleStringProperty cosprod;
	@FXML private SimpleDoubleProperty cosqty;
	@FXML private SimpleDoubleProperty cosraw;
	@FXML private SimpleDoubleProperty cospack;
	@FXML private SimpleDoubleProperty cosman;
	@FXML private SimpleDoubleProperty cosfuel;
	@FXML private SimpleDoubleProperty cosel;
	@FXML private SimpleDoubleProperty coover;
	@FXML private SimpleDoubleProperty coscost;
	@FXML private SimpleDoubleProperty cosstd;
	
	public CostTabsetget (String cosdate, String cosfact,String cosprod,Double cosqty,Double cosraw, Double cospack,Double cosman, Double cosfuel,Double cosel,
			Double coover, Double coscost, Double cosstd) {
		this.cosdate = new SimpleStringProperty(cosdate);
		this.cosfact = new SimpleStringProperty(cosfact);
		this.cosprod = new SimpleStringProperty(cosprod);
		this.cosqty = new SimpleDoubleProperty(cosqty);
		this.cosraw = new SimpleDoubleProperty(cosraw);
		this.cospack = new SimpleDoubleProperty(cospack);
		this.cosman = new SimpleDoubleProperty(cosman);
		this.cosfuel = new SimpleDoubleProperty(cosfuel);
		this.cosel = new SimpleDoubleProperty(cosel);
		this.coover = new SimpleDoubleProperty(coover);
		this.coscost = new SimpleDoubleProperty(coscost);
		this.cosstd = new SimpleDoubleProperty(cosstd);
		
		
	}
	
	public String getCosdate() {
		return cosdate.get();
	}
	public void setCosdate(SimpleStringProperty cosdate) {
		this.cosdate = cosdate;
	}
	public String getCosfact() {
		return cosfact.get();
	}
	public void setCosfact(SimpleStringProperty cosfact) {
		this.cosfact = cosfact;
	}
	public String getCosprod() {
		return cosprod.get();
	}
	public void setCosprod(SimpleStringProperty cosprod) {
		this.cosprod = cosprod;
	}
	public Double getCosqty() {
		return cosqty.get();
	}
	public void setCosqty(SimpleDoubleProperty cosqty) {
		this.cosqty = cosqty;
	}
	public Double getCosraw() {
		return cosraw.get();
	}
	public void setCosraw(SimpleDoubleProperty cosraw) {
		this.cosraw = cosraw;
	}
	public Double getCospack() {
		return cospack.get();
	}
	public void setCospack(SimpleDoubleProperty cospack) {
		this.cospack = cospack;
	}
	public Double getCosman() {
		return cosman.get();
	}
	public void setCosman(SimpleDoubleProperty cosman) {
		this.cosman = cosman;
	}
	public Double getCosfuel() {
		return cosfuel.get();
	}
	public void setCosfuel(SimpleDoubleProperty cosfuel) {
		this.cosfuel = cosfuel;
	}
	public Double getCosel() {
		return cosel.get();
	}
	public void setCosel(SimpleDoubleProperty cosel) {
		this.cosel = cosel;
	}
	public Double getCoover() {
		return coover.get();
	}
	public void setCoover(SimpleDoubleProperty coover) {
		this.coover = coover;
	}
	public Double getCoscost() {
		return coscost.get();
	}
	public void setCoscost(SimpleDoubleProperty coscost) {
		this.coscost = coscost;
	}
	public Double getCosstd() {
		return cosstd.get();
	}
	public void setCosstd(SimpleDoubleProperty cosstd) {
		this.cosstd = cosstd;
	}
	

}
