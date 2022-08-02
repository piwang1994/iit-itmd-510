package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class ClientController {
	
	static int userid; //class level variable
	
	public void logout() {
		//Exit JVM
		//System.exit(0);
		 try {
			   AnchorPane root = (AnchorPane) 
			   FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			   Scene scene = new Scene(root);    
			   scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			   Main.stage.setScene(scene);
			   Main.stage.setTitle("Login");
			  } catch (Exception e) {
			  System.out.println("Error occured while inflating view: " + 
			e.getMessage());
			  }

	}


	public ClientController() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("From Customer controller");
		alert.setHeaderText("Bank Of IIT- Chicago Main Branch");
		alert.setContentText("Welcome !");
		alert.showAndWait();

	}

	public static void setUserId(int user_id) {
		userid = user_id;
		System.out.println("Welcome id " + userid);
	}

	
	
	

}
