package application.controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductionSummaryController implements Initializable {

	@FXML
	private BarChart<String, Double> productionsBarChart;

	@FXML
	private PieChart expensepieChart;
	 @FXML
	    private ComboBox<Dashboardchoosesetget> comboChooser;
	@FXML
	private TabPane reviewsTabpane;
	@FXML
	private TableView<SummaryTabsetget> summaryTable;
	@FXML
	private TableColumn<SummaryTabsetget, String> sudate;
	@FXML
	private TableColumn<SummaryTabsetget, String> sufact;
	@FXML
	private TableColumn<SummaryTabsetget, String> suprod;
	@FXML
	private TableColumn<SummaryTabsetget, Double> suqty;
	@FXML
	private TableColumn<SummaryTabsetget, Double> sucost;
	@FXML
	private TableColumn<SummaryTabsetget, Double> susell;
	@FXML
	private TableColumn<SummaryTabsetget, Double> suprof;
	@FXML
	private TableView<ExpenseTabsetget> expenseTable;
	@FXML
	private TableColumn<ExpenseTabsetget, String> expdate;
	@FXML
	private TableColumn<ExpenseTabsetget, String> expfact;
	@FXML
	private TableColumn<ExpenseTabsetget, String> exprod;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expqty;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expraw;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expack;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expman;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expboil;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expel;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expexc;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expamt;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expcost;
	@FXML
	private TableColumn<ExpenseTabsetget, Double> expwat;
	@FXML
	private TextField bestDate;
	@FXML
	private TextField bestProduct;
	@FXML
	private TextField bestProfit;
	@FXML
	private TextField worstDate;
	@FXML
	private TextField worstProduct;
	@FXML
	private TextField worstQty;
	@FXML
	private TableView<CostTabsetget> detailedcostingTable;
	@FXML
	private TableColumn<CostTabsetget, String> cosdate;
	@FXML
	private TableColumn<CostTabsetget, String> cosfact;
	@FXML
	private TableColumn<CostTabsetget, String> cosprod;
	@FXML
	private TableColumn<CostTabsetget, Double> cosqty;
	@FXML
	private TableColumn<CostTabsetget, Double> cosraw;
	@FXML
	private TableColumn<CostTabsetget, Double> cospack;
	@FXML
	private TableColumn<CostTabsetget, Double> cosman;
	@FXML
	private TableColumn<CostTabsetget, Double> cosfuel;
	@FXML
	private TableColumn<CostTabsetget, Double> cosel;
	@FXML
	private TableColumn<CostTabsetget, Double> coover;
	@FXML
	private TableColumn<CostTabsetget, Double> coscost;
	@FXML
	private TableColumn<CostTabsetget, Double> cosstd;
	//    @Override
	public void initialize(URL Location, ResourceBundle resources) {
		sudate.setCellValueFactory(new PropertyValueFactory<SummaryTabsetget, String>("Sumdate"));
		sufact.setCellValueFactory(new PropertyValueFactory<SummaryTabsetget, String>("Sumfact"));
		suprod.setCellValueFactory(new PropertyValueFactory<SummaryTabsetget, String>(("Sumprod")));
		suqty.setCellValueFactory(new PropertyValueFactory<SummaryTabsetget, Double>(("Sumqty")));
		sucost.setCellValueFactory(new PropertyValueFactory<SummaryTabsetget, Double>(("Sumcost")));
		susell.setCellValueFactory(new PropertyValueFactory<SummaryTabsetget, Double>(("Sumsell")));
		suprof.setCellValueFactory(new PropertyValueFactory<SummaryTabsetget, Double>("Sumprofit"));

		expdate.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, String>("Expdate"));
		expfact.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, String>("Expfact"));
		exprod.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, String>("Expprod"));
		expqty.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expqty"));
		expraw.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expraw"));
		expack.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expack"));
		expman.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expman"));
		expboil.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expboil"));
		expel.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expel"));
		expwat.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expwat"));
		expexc.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expexc"));
		expamt.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expamt"));
		expcost.setCellValueFactory(new PropertyValueFactory<ExpenseTabsetget, Double>("Expcost"));
		
		cosdate.setCellValueFactory(new PropertyValueFactory<CostTabsetget, String>("Cosdate"));
		cosfact.setCellValueFactory(new PropertyValueFactory<CostTabsetget, String>("Cosfact"));
		cosprod.setCellValueFactory(new PropertyValueFactory<CostTabsetget, String>("Cosprod"));
		cosqty.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosqty"));
		cosraw.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosraw"));
		cospack.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cospack"));
		cosman.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosman"));
		cosfuel.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosfuel"));
		cosel.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosel"));
		coover.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Coover"));
		coscost.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Coscost"));
		cosstd.setCellValueFactory(new PropertyValueFactory<CostTabsetget, Double>("Cosstd"));
		comboChooser.setItems(getdashchoice());		
		getsummarydatapreview();
		getexpensedatapreview();
		getCostdatapreview();
		loadperformingproducts();
		loadproductionChart();
	}

	ObservableList<SummaryTabsetget> summarytabledata = FXCollections.observableArrayList();
	ObservableList<ExpenseTabsetget> expensetabledata = FXCollections.observableArrayList();
	ObservableList<CostTabsetget> costtabledata = FXCollections.observableArrayList();
	ObservableList<Dashboardchoosesetget> combochooserdata = FXCollections.observableArrayList();
	
	public static final LocalDate NOW_LOCAL_DATE() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}
@FXML
	public void loadDashboard() {
				String shusenmode = comboChooser.getValue().toString();
				switch (shusenmode){
				
				case "This Weeks":
					weeklydash();
					weekExpense();
					weekCost();
					weekProduction();
					weekPerformer();
					break;
				case "This Months":
					monthlydash();
					monthExpense();
					monthCost();
					monthProduction();
					monthPerformer();
					break;
				case "This Years":
					yeardash();
					yearExpense();
					yearCost();
					yearProduction();
					yearPerformer();
					break;
				}				
}	
	public void getsummarydatapreview() {
		weeklydash();
	}	
	public void weeklydash() {
		ObservableList<SummaryTabsetget> allitems, singleitems;
		allitems = summaryTable.getItems();
		singleitems = summaryTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from new_view where week(date)=week(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				summarytabledata.add(new SummaryTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product"), rs.getDouble("quantity"), rs.getDouble("Cperunit_inclusive"),
						rs.getDouble("selling_price_disc"), rs.getDouble("percentage_profit")));
			}
			summaryTable.setItems(summarytabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void monthlydash() {
		ObservableList<SummaryTabsetget> allitems, singleitems;
		allitems = summaryTable.getItems();
		singleitems = summaryTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from new_view where month(date)=month(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				summarytabledata.add(new SummaryTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product"), rs.getDouble("quantity"), rs.getDouble("Cperunit_inclusive"),
						rs.getDouble("selling_price_disc"), rs.getDouble("percentage_profit")));
			}
			summaryTable.setItems(summarytabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void yeardash() {
		ObservableList<SummaryTabsetget> allitems, singleitems;
		allitems = summaryTable.getItems();
		singleitems = summaryTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from new_view where year(date)=year(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				summarytabledata.add(new SummaryTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product"), rs.getDouble("quantity"), rs.getDouble("Cperunit_inclusive"),
						rs.getDouble("selling_price_disc"), rs.getDouble("percentage_profit")));
			}
			summaryTable.setItems(summarytabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getexpensedatapreview() {
		weekExpense();
	}
	/**
	 * 
	 */
	public void weekExpense() {
		ObservableList<ExpenseTabsetget> allitems, singleitems;
		allitems = expenseTable.getItems();
		singleitems = expenseTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from summary_view where week(date)=week(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				expensetabledata.add(new ExpenseTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product_name"), rs.getDouble("quantity"), rs.getDouble("raw material amount"),
						rs.getDouble("package amount"), rs.getDouble("manpower amount"), rs.getDouble("boiler amount"),
						rs.getDouble("electricity amount"), rs.getDouble("water amount"),
						rs.getDouble("excise duty amount"), rs.getDouble("total_amount"),
						rs.getDouble("cost_per_unit")));
			}
			expenseTable.setItems(expensetabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void monthExpense() {
		ObservableList<ExpenseTabsetget> allitems, singleitems;
		allitems = expenseTable.getItems();
		singleitems = expenseTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from summary_view where month(date)=month(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				expensetabledata.add(new ExpenseTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product_name"), rs.getDouble("quantity"), rs.getDouble("raw material amount"),
						rs.getDouble("package amount"), rs.getDouble("manpower amount"), rs.getDouble("boiler amount"),
						rs.getDouble("electricity amount"), rs.getDouble("water amount"),
						rs.getDouble("excise duty amount"), rs.getDouble("total_amount"),
						rs.getDouble("cost_per_unit")));
			}
			expenseTable.setItems(expensetabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void yearExpense() {
		ObservableList<ExpenseTabsetget> allitems, singleitems;
		allitems = expenseTable.getItems();
		singleitems = expenseTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from summary_view where year(date)=year(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				expensetabledata.add(new ExpenseTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product_name"), rs.getDouble("quantity"), rs.getDouble("raw material amount"),
						rs.getDouble("package amount"), rs.getDouble("manpower amount"), rs.getDouble("boiler amount"),
						rs.getDouble("electricity amount"), rs.getDouble("water amount"),
						rs.getDouble("excise duty amount"), rs.getDouble("total_amount"),
						rs.getDouble("cost_per_unit")));
			}
			expenseTable.setItems(expensetabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getCostdatapreview() {
		weekCost();
	}
	/**
	 * 
	 */
	public void weekCost() {
		ObservableList<CostTabsetget> allitems, singleitems;
		allitems = detailedcostingTable.getItems();
		singleitems = detailedcostingTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from new_view where week(date)=week(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				costtabledata.add(new CostTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product"), rs.getDouble("quantity"), rs.getDouble("RawCost"),
						rs.getDouble("cancost"), rs.getDouble("mancost"), rs.getDouble("briqcost"),
						rs.getDouble("elecost"), rs.getDouble("overhead_per_pc"),
						rs.getDouble("Cperunit_inclusive"), rs.getDouble("selling_price_disc")));
			}
			detailedcostingTable.setItems(costtabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void monthCost() {
		ObservableList<CostTabsetget> allitems, singleitems;
		allitems = detailedcostingTable.getItems();
		singleitems = detailedcostingTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from new_view where month(date)=month(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				costtabledata.add(new CostTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product"), rs.getDouble("quantity"), rs.getDouble("RawCost"),
						rs.getDouble("cancost"), rs.getDouble("mancost"), rs.getDouble("briqcost"),
						rs.getDouble("elecost"), rs.getDouble("overhead_per_pc"),
						rs.getDouble("Cperunit_inclusive"), rs.getDouble("selling_price_disc")));
			}
			detailedcostingTable.setItems(costtabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void yearCost() {
		ObservableList<CostTabsetget> allitems, singleitems;
		allitems = detailedcostingTable.getItems();
		singleitems = detailedcostingTable.getSelectionModel().getSelectedItems();
		// singleitems.forEach(allitems::remove);
		allitems.clear();
		allitems.removeAll();
		try {
			String weekdate = NOW_LOCAL_DATE().toString();
			String sqlget = "select * from new_view where year(date)=year(?)and year(date)>=2021";
			PreparedStatement psget = DbConnection.getInstance().prepareStatement(sqlget);
			psget.setString(1, weekdate);
			ResultSet rs = psget.executeQuery();
			while (rs.next()) {
				costtabledata.add(new CostTabsetget(rs.getString("date"), rs.getString("factory"),
						rs.getString("product"), rs.getDouble("quantity"), rs.getDouble("RawCost"),
						rs.getDouble("cancost"), rs.getDouble("mancost"), rs.getDouble("briqcost"),
						rs.getDouble("elecost"), rs.getDouble("overhead_per_pc"),
						rs.getDouble("Cperunit_inclusive"), rs.getDouble("selling_price_disc")));
			}
			detailedcostingTable.setItems(costtabledata);
			// tblupstocks.setItems(null);
		} catch (InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void loadproductionChart() {
		weekProduction();

	}
	/**
	 * 
	 */
	public void weekProduction() {
		String weekdate = NOW_LOCAL_DATE().toString();
		XYChart.Series<String, Double> series = new XYChart.Series();
		String squery = "select distinct(product_name) as product_name,quantity from summary_view where week(date)=week(?) group by week(date),product_name";
		PreparedStatement pssp;
		try {
			pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						series.getData()
								.add(new XYChart.Data<>(rssr.getString("product_name"), rssr.getDouble("quantity")));
					}
					productionsBarChart.getData().add(series);
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
	public void monthProduction() {
		String weekdate = NOW_LOCAL_DATE().toString();
		XYChart.Series<String, Double> series = new XYChart.Series();
		String squery = "select distinct(product_name) as product_name,quantity from summary_view where month(date)=month(?) group by month(date),product_name";
		PreparedStatement pssp;
		try {
			pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						series.getData()
								.add(new XYChart.Data<>(rssr.getString("product_name"), rssr.getDouble("quantity")));
					}
					productionsBarChart.getData().add(series);
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
	public void yearProduction() {
		String weekdate = NOW_LOCAL_DATE().toString();
		XYChart.Series<String, Double> series = new XYChart.Series();
		String squery = "select distinct(product_name) as product_name,quantity from summary_view where year(date)=year(?) group by year(date),product_name";
		PreparedStatement pssp;
		try {
			pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						series.getData()
								.add(new XYChart.Data<>(rssr.getString("product_name"), rssr.getDouble("quantity")));
					}
					productionsBarChart.getData().add(series);
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
	@FXML
	private void loadperformingproducts() {
		weekPerformer();
	}
	/**
	 * 
	 */
	public void weekPerformer() {
		String weekdate = NOW_LOCAL_DATE().toString();
		try {
			String squery = "select max(percentage_profit) as percentage_profit,product,date from new_view where week(date)=week(?)and year(date)>=2021";
			PreparedStatement pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						Double pri = rssr.getDouble("percentage_profit");
						bestProfit.setText(String.valueOf(pri));
						bestProduct.setText(String.valueOf(rssr.getString("product")));
						bestDate.setText(String.valueOf(rssr.getString("date")));
					
					}

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
		try {
			String squery = "select min(percentage_profit) as percentage_profit,product,date from new_view where week(date)=week(?)and year(date)>=2021";
			PreparedStatement pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						Double pri = rssr.getDouble("percentage_profit");
						worstQty.setText(String.valueOf(pri));
						worstProduct.setText(String.valueOf(rssr.getString("product")));
						worstDate.setText(String.valueOf(rssr.getString("date")));
					
					}

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
	
	public void monthPerformer() {
		String weekdate = NOW_LOCAL_DATE().toString();
		try {
			String squery = "select max(percentage_profit) as percentage_profit,product,date from new_view where month(date)=month(?)and year(date)>=2021";
			PreparedStatement pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						Double pri = rssr.getDouble("percentage_profit");
						bestProfit.setText(String.valueOf(pri));
						bestProduct.setText(String.valueOf(rssr.getString("product")));
						bestDate.setText(String.valueOf(rssr.getString("date")));
					
					}

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
		try {
			String squery = "select min(percentage_profit) as percentage_profit,product,date from new_view where month(date)=month(?)and year(date)>=2021";
			PreparedStatement pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						Double pri = rssr.getDouble("percentage_profit");
						worstQty.setText(String.valueOf(pri));
						worstProduct.setText(String.valueOf(rssr.getString("product")));
						worstDate.setText(String.valueOf(rssr.getString("date")));
					
					}

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
	public void yearPerformer() {
		String weekdate = NOW_LOCAL_DATE().toString();
		try {
			String squery = "select max(percentage_profit) as percentage_profit,product,date from new_view where year(date)=year(?)and year(date)>=2021";
			PreparedStatement pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						Double pri = rssr.getDouble("percentage_profit");
						bestProfit.setText(String.valueOf(pri));
						bestProduct.setText(String.valueOf(rssr.getString("product")));
						bestDate.setText(String.valueOf(rssr.getString("date")));
					
					}

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
		try {
			String squery = "select min(percentage_profit) as percentage_profit,product,date from new_view where year(date)=year(?)and year(date)>=2021";
			PreparedStatement pssp = DbConnection.getInstance().prepareStatement(squery);
			pssp.setString(1, weekdate);
			ResultSet rssr;
			try {
				rssr = pssp.executeQuery();

				try {
					while (rssr.next()) {
						Double pri = rssr.getDouble("percentage_profit");
						worstQty.setText(String.valueOf(pri));
						worstProduct.setText(String.valueOf(rssr.getString("product")));
						worstDate.setText(String.valueOf(rssr.getString("date")));
					
					}

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
	public ObservableList<Dashboardchoosesetget> getdashchoice() {
		ObservableList<Dashboardchoosesetget> foode = FXCollections.observableArrayList(new Dashboardchoosesetget("This Weeks"),
				new Dashboardchoosesetget("This Months"), new Dashboardchoosesetget("This Years")

		);
		return foode;
	}

	@FXML
	private void getDataBarProduction() {

	}
}
