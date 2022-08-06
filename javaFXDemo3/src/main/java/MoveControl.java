import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MoveControl {
    @FXML
    Label la;
    @FXML
    Button bu;

    public void onUp(){
        la.setLayoutY(la.getLayoutY()-10);
    }
}
