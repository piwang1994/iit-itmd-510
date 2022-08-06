package com.iit.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;


public class Main extends Application {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init...");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop...");
        super.stop();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("123");
        primaryStage.setTitle("hello");
        primaryStage.getIcons().add(new Image("image/20220806113154.png"));
        primaryStage.setResizable(true);

        Button butt0 = new Button("hello word1");
        Button butt1 = new Button("hello word2");
        butt0.setLayoutX(200);
        butt1.setLayoutX(200);
        butt0.setLayoutY(200);
        butt1.setLayoutY(250);
        butt0.setOnAction(event -> {
            Stage stage = new Stage();
            stage.setHeight(200);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        });

        primaryStage.setOnCloseRequest(
                event -> {
                    event.consume();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("退出程序");
                    alert.setHeaderText(null);
                    alert.setContentText("是否exit ");
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(ButtonType.OK==buttonType.get()){
                        primaryStage.close();
                    }
                }
        );
        AnchorPane pane = new AnchorPane();
//        pane.getChildren().add(butt);
        pane.getChildren().addAll(butt0,butt1);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);


        primaryStage.show();
        //        primaryStage.close();
    }
}
