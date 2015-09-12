package alexiuscrow.epl.controllers;

import alexiuscrow.epl.domain.Participant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Alexiuscrow on 30.08.2015.
 */
public class ParticipantListCellController extends ListCell<Participant> {

    @FXML private HBox mainHBox;
    @FXML private Rectangle onlineIndicator;
    @FXML private ImageView avatar;
    @FXML private Label fullName;
    @FXML private Label inviteStatus;
    @FXML private SplitMenuButton btnShowPage;
    @FXML private MenuItem miWriteMsg;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantListCellController.class);

    public ParticipantListCellController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/GUIListItem.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init(Participant participant) {

        if (participant.isOnline() != null && participant.isOnline())
            onlineIndicator.setFill(Color.LAWNGREEN);

        if (participant.getUrlPhoto100() != null)
            avatar.setImage(new Image(participant.getUrlPhoto100()));

        fullName.setText(participant.getFullName());

        if (participant.isInvited() != null && participant.isInvited()) {
            inviteStatus.setText("Invited");
        } else {
            inviteStatus.setText("Not invited");
        }

        if (!participant.canWritePrivateMsg()) {
            btnShowPage.getItems().remove(miWriteMsg);
        }

        btnShowPage.setOnAction(e -> {
            LOGGER.info("Show page"); //TODO
        });

        miWriteMsg.setOnAction(e -> {
            LOGGER.info("Write message"); //TODO
        });
    }

    public Node getRootNode() {
        return mainHBox;
    }

    @Override
    public void updateItem(Participant participant, boolean empty) {
        super.updateItem(participant, empty);

        if (empty || participant == null)
            return;

        init(participant);
        setGraphic(getRootNode());

    }
}
