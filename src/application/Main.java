package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;



public class Main extends Application {
	@FXML
	StackPane StackPaneMain;
	private Stage primaryStage;
	public static BorderPane mainLayout;
	Parent root;
	Stage stage;

		@Override
		public  void start(Stage primaryStage) throws IOException {
			 root=FXMLLoader.load(getClass().getResource("controllers/MainPanel.fxml"));
			this.primaryStage=primaryStage;
			this.primaryStage.setTitle("Njoro Canning Factory");
			primaryStage.setMaximized(true);
			showLoginView();
//			LoadDashboardFXML();
		}
		private void showLoginView() throws IOException {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("controllers/MainPanel.fxml"));
			mainLayout=loader.load();
			Scene scene=new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
//			System.out.println(System.getProperties());
			}
		public void LoadDashboardFXML() throws IOException
		{
		    StackPaneMain.getChildren().clear();
		    StackPaneMain.getChildren().add(FXMLLoader.load(getClass().getResource("/controllers/ProductionSummaryDashboard.fxml")));
		    StackPaneMain.setLayoutX(0);
		    StackPaneMain.setLayoutY(0);
		}

	public static void main(String[] args) {
		launch(args);
	}
}
