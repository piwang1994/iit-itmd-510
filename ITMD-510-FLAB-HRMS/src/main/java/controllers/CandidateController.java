package controllers;

import application.DynamicTable;
import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.CandidateModel;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

public class CandidateController implements Initializable {

    static String userid;
    static String userName;
    CandidateModel cm;

    /***** TABLEVIEW intel *********************************************************************/


    @FXML
    private TableView<CandidateModel> appList;
    @FXML
    private TableColumn<CandidateModel, String> job;
    @FXML
    private TableColumn<CandidateModel, String> result;


    public CandidateController() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("good job for you");
        alert.setHeaderText("fire your boss and get better job");
        alert.setContentText("Welcome !");
        alert.showAndWait();

        cm = new CandidateModel();
    }

    public static void setUserid(String user_id) {
        userid = user_id;
        System.out.println("Welcome id >>>>>>>>>>>>> " + userid);
    }

    public void viewJobs() {

        DynamicTable d = new DynamicTable();
        // call method from DynamicTable class and pass some arbitrary query string
        d.buildData("Select job.* from \n" +
                "job LEFT JOIN apply\n" +
                "on job.job_id=apply.job_id\n" +
                "WHERE apply.job_id is null or apply.cid='"+userid+"'  ");

    }


    public void getApplist() {

        appList.getItems().setAll(cm.getAppList(userid)); // load table data from ClientModel List
        appList.setVisible(true); // set tableview to visible if not

    }


    public void initialize(URL location, ResourceBundle resources) {
        job.setCellValueFactory(new PropertyValueFactory<CandidateModel, String>("job_name"));
        result.setCellValueFactory(new PropertyValueFactory<CandidateModel, String>("result"));

        // auto adjust width of columns depending on their content
        appList.setColumnResizePolicy((param) -> true);
        Platform.runLater(() -> customResize(appList));

        appList.setVisible(true); // set invisible initially
    }





    public void createApp() {

        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("JOB  Entry Portal");
        dialog.setHeaderText("Apply for job");
        dialog.setContentText("Please enter job id:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("job id is: " + result.get());
            cm.insertRecord(userid, result.get());
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(ele -> System.out.println("Apply for job : " + ele));

    }

    /***** End TABLEVIEW intel *********************************************************************/

    public void logout() {
        // System.exit(0);
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application/styles.css").toExternalForm());
            Main.stage.setScene(scene);
            Main.stage.setTitle("Login");
        } catch (Exception e) {
            System.out.println("Error occured while inflating view: " + e);
        }
    }

    public void customResize(TableView<?> view) {

        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth() + ((tableWidth - width.get()) / view.getColumns().size()));
            });
        }
    }

}
