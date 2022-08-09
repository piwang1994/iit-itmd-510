package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.ClientModel;
 

public class ClientController implements Initializable {
	

	ClientModel cm;
	
	@FXML
	private TableView<ClientModel> tblAccounts;
	@FXML
	private TableColumn<ClientModel, String> tid;
	@FXML
	private TableColumn<ClientModel, String> balance;

	static int userid; //class level variable


	public void initialize(URL location, ResourceBundle resources) {
		tid.setCellValueFactory(
        new PropertyValueFactory<ClientModel, String>("tid"));
		balance.setCellValueFactory(
        new PropertyValueFactory<ClientModel, String>("balance"));

		// auto adjust width of columns depending on their content
		tblAccounts.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tblAccounts));

		tblAccounts.setVisible(false); // set invisible initially
	}

	 public void customResize(TableView<?> view) {

	        AtomicLong width = new AtomicLong();
	        view.getColumns().forEach(col -> {
	            width.addAndGet((long) col.getWidth());
	        });
	        double tableWidth = view.getWidth();

	        if (tableWidth > width.get()) {
	            view.getColumns().forEach(col -> {
	                col.setPrefWidth(col.getWidth()+((tableWidth-width.get())/view.getColumns().size()));
	            });
	        }
	    }

		public void logout() {
			// System.exit(0);
			try {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				Main.stage.setScene(scene);
				Main.stage.setTitle("Login");
			} catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
		}


	public ClientController() {
		/*
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("From Customer controller");
		alert.setHeaderText("Bank Of IIT- Chicago Main Branch");
		alert.setContentText("Welcome !");
		alert.showAndWait();
		*/
		cm = new ClientModel();

	}

	public static void setUserId(int user_id) {
		userid = user_id;
		System.out.println("Welcome id " + userid);
	}
	
	 
	public void viewAccounts() throws IOException {
			// load data from ClientModel List
			tblAccounts.getItems().setAll(cm.getAccounts(userid)); //bind to table 
			tblAccounts.setVisible(true); // set table view to visible if not
			 
	}


	 public void createTransaction() {

			TextInputDialog dialog = new TextInputDialog("Enter dollar amount");
			dialog.setTitle("Bank Account Entry Portal");
			dialog.setHeaderText("Enter Transaction");
			dialog.setContentText("Please enter your balance:");

			// Traditional way to get the response value.
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				System.out.println("Balance entry: " + result.get());
				cm.insertRecord(userid,Double.parseDouble(result.get()));
			}

		}

 


	

}
