import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controls the login screen
 */
public class LoginController {

    private static int sessionID = 0;
    @FXML
    private TextField user;
    @FXML
    private TextField password;

    // public void initialize() {}
    @FXML
    private Button loginButton;

    public void initManager(final LoginManager loginManager) {

        loginButton.setOnAction((e) -> {
            String sessionID = authorize();
            if (sessionID != null)
                loginManager.authenticated(sessionID);
        });

    }

    /**
     * Check authorization credentials.
     * <p>
     * If accepted, return a sessionID for the authorized session
     * otherwise, return null.
     */
    private String authorize() {
        return
                "open".equals(user.getText()) && "sesame".equals(password.getText())
                        ? generateSessionID()
                        : null;
    }

    private String generateSessionID() {
        sessionID++;
        return "xyzzy - session " + sessionID;
    }
}
