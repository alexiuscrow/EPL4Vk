package alexiuscrow.epl.controllers;

import alexiuscrow.epl.domain.Participant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

        if (participant.isOnline())
            onlineIndicator.setFill(Color.LIMEGREEN);

        if (participant.getAvatar() != null)
            avatar.setImage(new Image(participant.getAvatar().toString()));

        fullName.setText(participant.getFullName());

        if (participant.isInvited()) {
            inviteStatus.setText("Invited");
        } else {
            inviteStatus.setText("Not invited");
        }

        btnShowPage.setOnAction(e -> {
            System.out.println("Show page"); //TODO
        });

        miWriteMsg.setOnAction(e -> {
            System.out.println("Write message"); //TODO
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
