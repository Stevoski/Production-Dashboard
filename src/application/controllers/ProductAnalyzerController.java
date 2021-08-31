package application.controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductAnalyzerController implements Initializable {

    @FXML
    private LineChart<String, Double> averagLiner;

    @FXML
    private TextField productField;

    @FXML
    private Button btnLoader;

    @FXML
    private TableView<CostTabsetget> tblReport;

    @FXML
    private TableColumn<CostTabsetget,String> colMonth;

    @FXML
    private TableColumn<CostTabsetget, String> colProd;

    @FXML
    private TableColumn<CostTabsetget, String> colFact;
    
    @FXML
    private TableColumn<CostTabsetget, Double> colQty;

    @FXML
    private TableColumn<CostTabsetget, Double> colRaw;

    @FXML
    private TableColumn<CostTabsetget, Double> colPack;

    @FXML
    private TableColumn<CostTabsetget, Double> colEle;

    @FXML
    private TableColumn<CostTabsetget, Double> colFuel;

    @FXML
    private TableColumn<CostTabsetget, Double> colManp;

    @FXML
    private TableColumn<CostTabsetget, Double> colAvg;
    @FXML
    private TableColumn<CostTabsetget, Double> colOver;
    @FXML
    private TableColumn<CostTabsetget, Double> colStd;
    @Override
    public void initialize(URL Location, ResourceBundle resources) {
    	colMonth.setCellValueFactory(new PropertyValueFactory<CostTabsetget, String>("Cosdate"));
		colFact.setCellValueFactory(new PropertyValueFactory<CostTabsetget, String>("Cosfact"));
		colProd.setCellValueFactory(new PropertyValueFactory<CostTabsetget, String>("Cosprod"));
		colQty.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosqty"));
		colRaw.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosraw"));
		colPack.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cospack"));
		colManp.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosman"));
		colFuel.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosfuel"));
		colEle.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosel"));
		colOver.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Coover"));
		colAvg.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Coscost"));
		colStd.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosstd"));
		TextFields.bindAutoCompletion(productField, productAutocomplete());
    }
    ObservableList<CostTabsetget> costtabledata = FXCollections.observableArrayList();
    public void loadCostTable() {
    	String prodname=productField.getText();
		ObservableList<CostTabsetget> allitems, singleitems;
		allitems = tblReport.getItems();
		singleitems = tblReport.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			
			String sqlget = "select * from monthly_averages where product=?";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, prodname);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				costtabledata.add(new CostTabsetget(rs.getString("month"), rs.getString("factory"),
						rs.getString("product"), rs.getDouble("quantity"), rs.getDouble("RawCost"),
						rs.getDouble("cancost"), rs.getDouble("mancost"), rs.getDouble("fuelcost"),
						rs.getDouble("elecost"), rs.getDouble("overhead_per_pc"),
						rs.getDouble("AveragePrice"), rs.getDouble("selling_price_disc")));
			}
			tblReport.setItems(costtabledata);
			loadProductionChart();
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
    public ArrayList<String> productAutocomplete() {
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement psffood;
		try {
			psffood = DbConnection.getInstance().prepareStatement("select distinct(product_name) from product");
			ResultSet rs;
			try {
				rs = psffood.executeQuery();
				try {
					while (rs.next()) {
						list.add(rs.getString("product_name"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (InstantiationException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return list;
		}
    
    public void loadProductionChart() {
		String cproduct = productField.getText();
		LineChart.Series<String, Double> series = new LineChart.Series();
		series.setName("Monthly Averages for '"+cproduct +"'");
		String squery = "select distinct(month) as month,averageprice from monthly_averages where product=?";
		PreparedStatement pssp;
		try {
			pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, cproduct);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						series.getData()
								.add(new XYChart.Data<>(rssr.getString("month"), rssr.getDouble("averageprice")));
					}
					averagLiner.getData().add(series);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
