package alexiuscrow.epl.controllers;

import alexiuscrow.epl.ws.client.WSClient;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Alexiuscrow on 05.09.2015.
 */
public class WebBrowserController {
    private Stage stage;
    private GridPane pane;
    private WebView webView;

    public String display(String url) {
        stage = new Stage();
        stage.setWidth(550);
        stage.setHeight(450);
        stage.initModality(Modality.APPLICATION_MODAL);

        pane = new GridPane();
        webView = new WebView();
        webView.getEngine().load(url);
        webView.getEngine().getLoadWorker().stateProperty().addListener((ov, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                if (webView.getEngine().getLocation().startsWith(WSClient.AUTH_REDIRECT_URL))
                    stage.close();
            }
        });
        pane.getChildren().add(webView);

        Parent root = pane;

        stage.setTitle("Auth");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        return webView.getEngine().getLocation();
    }
}
