package alexiuscrow.epl.controllers;

import alexiuscrow.epl.Settings;
import alexiuscrow.epl.domain.Participant;
import alexiuscrow.epl.domain.ParticipantsResponse;
import alexiuscrow.epl.utils.ImageManager;
import alexiuscrow.epl.ws.client.WSClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML private Button btnSettings;
    @FXML private Button btnUpdList;
    @FXML private ChoiceBox<String> chbParticipant;
    @FXML private ListView<Participant> lvParticipants;
    @FXML private Label lblNotify;
    @FXML private ImageView imgNotify;
    @FXML private MenuButton mBtnProfile;
    @FXML private ImageView imgProfile;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (!auth())
                return;

            updateProfile();
            updateList();

        } catch (Exception e) {
            LOGGER.error("!!!", e);
        }
    }

    public boolean auth() {
        LOGGER.debug("Auth request url: " + WSClient.AUTH_URL);
        String responseUrl = new WebBrowserController().display(WSClient.AUTH_URL);
        LOGGER.debug("Auth response url: " + responseUrl);
        responseUrl = responseUrl.replace("#", "?");
        Map<String, String> params = new HashMap<String, String>();
        try {
            List<NameValuePair> listParams = URLEncodedUtils.parse(new URI(responseUrl), "UTF-8");

            for (NameValuePair pair: listParams)
                params.put(pair.getName(), pair.getValue());

            WSClient.setToken(params.get("access_token"));
            Settings.setProfile(WSClient.getProfile(Long.valueOf(params.get("user_id"))));

        } catch (URISyntaxException e) {
            LOGGER.error("!!!", e);
        }
        return WSClient.getToken() != null;
    }

    private void updateList() {
        ParticipantsResponse participantsResponse = WSClient.getAllMembers(Settings.getListenedEventsIds());
        ObservableList<Participant> data = FXCollections.observableArrayList();

        if (participantsResponse != null && participantsResponse.getParticipants() != null && participantsResponse.getParticipants().size() != 0) {
            data.addAll(participantsResponse.getParticipants());
        }

        lvParticipants.setItems(data);

        lvParticipants.setCellFactory(new Callback<ListView<Participant>, ListCell<Participant>>() {
            @Override
            public ListCell<Participant> call(ListView<Participant> param) {
                return new ParticipantListCellController();
            }
        });
    }

    private void updateProfile() {
        try {
            mBtnProfile.setText(Settings.getProfile().getFirstName());
            imgProfile.setImage(new Image(ImageManager.saveAndGetImageForProfile(new URL(Settings.getProfile().getUrlPhoto50()))));
        } catch (MalformedURLException e) {
            LOGGER.error("!!!", e);
        }
    }



    @FXML
    private void handleUpdBtnClick() {
        updateList();
    }

    @FXML
    private void handleSettingsBtnClick() {

    }
}
