package login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Application.launch(LoginDemoApplication.class,args);
    }
    static class LoginDemoApplication extends Application {

        @Override public void start(Stage stage) throws IOException {
            Scene scene = new Scene(new StackPane());

            LoginManager loginManager = new LoginManager(scene);
            loginManager.showLoginScreen();

            stage.setScene(scene);
            stage.show();
        }
    }
}
