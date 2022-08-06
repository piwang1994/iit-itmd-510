package com.iit.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;


public class MainScence extends Application {
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
        butt0.setLayoutX(200);
        butt0.setLayoutY(200);
        AnchorPane root= new AnchorPane();
        root.getChildren().addAll(butt0);
        Scene scene = new Scene(root, 500, 500);

//        pane.getChildren().add(butt);

        Button butt1 = new Button("hello word2");
        butt1.setLayoutX(200);
        butt1.setLayoutY(250);
        Label label1 = new Label("你好，javafx");
        AnchorPane root1= new AnchorPane();
        root1.getChildren().addAll(butt1,label1);
        Scene scene1 = new Scene(root1, 500, 500);


        butt0.setOnAction(event -> {
            primaryStage.setScene(scene1);
        });
        butt1.setOnAction(event -> {
            primaryStage.setScene(scene);
        });


        primaryStage.setScene(scene);


        primaryStage.show();
        //        primaryStage.close();
    }
}
