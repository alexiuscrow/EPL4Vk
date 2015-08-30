package alexiuscrow.epl.controllers;

import alexiuscrow.epl.view.ParticipantListCell;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML private Button btnSettings;
    @FXML private ChoiceBox<String> chbParticipant;
    @FXML private ListView<ParticipantListCell> lvParticipants;
    @FXML private Label lblNotify;
    @FXML private ImageView imgNotify;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
