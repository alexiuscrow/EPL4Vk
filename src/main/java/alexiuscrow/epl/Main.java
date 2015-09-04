package alexiuscrow.epl;

import alexiuscrow.epl.controllers.ConfirmController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/gui/GUIMain.fxml"));
        primaryStage.setTitle("Event Participant Listener");
        primaryStage.setScene(new Scene(root));

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        primaryStage.show();
    }

    private void closeProgram() {
        Boolean answer = new ConfirmController().display("Title", "Suru U want to exit?");
        if (answer)
            primaryStage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
