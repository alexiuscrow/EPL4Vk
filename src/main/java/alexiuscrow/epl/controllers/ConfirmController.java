package alexiuscrow.epl.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Alexiuscrow on 30.08.2015.
 */
public class ConfirmController {

    private boolean answer = false;
    private FXMLLoader fxmlLoader;

    @FXML private Label lblMsg;
    @FXML private Button btnYes;
    @FXML private Button btnNo;

    public ConfirmController() {
        fxmlLoader = new FXMLLoader(getClass().getResource("/gui/GUIConfirm.fxml"));
        fxmlLoader.setController(this);
    }


    public boolean display(String title, String msg) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();

            root = buildStageProgrammatically(msg);
        }

        lblMsg.setText(msg);

        btnYes.setOnAction(e -> {
            answer = true;
            stage.close();
        });

        btnNo.setOnAction(e -> {
            answer = false;
            stage.close();
        });


        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.showAndWait();
        return answer;
    }

    public Parent buildStageProgrammatically(String msg) {
        lblMsg = new Label(msg);
        btnYes = new Button("Yep");
        btnNo = new Button("No");
        btnYes.setAlignment(Pos.CENTER);
        btnNo.setAlignment(Pos.CENTER);
        btnNo.setFocusTraversable(true);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnYes, btnNo);
        hBox.setAlignment(Pos.CENTER);
        HBox.setMargin(btnYes, new Insets(5, 5, 0, 5));
        HBox.setMargin(btnNo, new Insets(5, 5, 0, 5));

        VBox vBox = new VBox(5);
        vBox.prefWidth(300d);
        vBox.getChildren().addAll(lblMsg, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(5));
        return vBox;
    }
}
