package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MainPanelController {
	  @FXML
	    private BorderPane MainCostDashboard;
	  @FXML
	    private StackPane stackpaned;
    @FXML
    private Button btDashboard;
    @FXML
    private Button btProduct;
    public void initialize(URL Location, ResourceBundle resources) {    	
    }
    public void loadDashboard() throws IOException {
    	stackpaned.getChildren().clear();
    	stackpaned.getChildren().add(FXMLLoader.load(getClass().getResource("ProductionSummaryDashboard.fxml")));
    	stackpaned.setLayoutX(0);
    	stackpaned.setLayoutY(0);    	
    }
    public void loadAnalyzer() throws IOException {
    	stackpaned.getChildren().clear();
    	stackpaned.getChildren().add(FXMLLoader.load(getClass().getResource("ProductAnalyzer.fxml")));
    	stackpaned.setLayoutX(0);
    	stackpaned.setLayoutY(0);    	
    }
}