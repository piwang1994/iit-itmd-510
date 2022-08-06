import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controls the Main application screen
 */
public class MainViewController {

    @FXML
    private Button logoutButton;
    @FXML
    private Label ssLabel;

    public void initSessionID(final LoginManager loginManager, String sessionID) {

        ssLabel.setText(sessionID);

        logoutButton.setOnAction(e -> loginManager.logout());

    }
}