package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

	public static Stage stage; // set global stage object!!!

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
            URL url = getClass().getResource("/views/LoginView.fxml");
            System.out.println(url);
            AnchorPane root = (AnchorPane) FXMLLoader.load(url);
			Scene scene = new Scene(root);
            url=getClass().getResource("application.css");
            System.out.println(url);
			scene.getStylesheets().add(url.toExternalForm());
			stage.setTitle("Login View");
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			System.out.println("Error occurred while inflating view: " + e);
            e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
