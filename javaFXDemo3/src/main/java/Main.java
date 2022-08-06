import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        Pane load = FXMLLoader.load(getClass().getResource("demo.fxml"));
        Scene scene = new Scene(load, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
