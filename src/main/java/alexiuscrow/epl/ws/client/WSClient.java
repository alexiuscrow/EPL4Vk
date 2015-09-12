package alexiuscrow.epl.ws.client;

import alexiuscrow.epl.Settings;
import alexiuscrow.epl.domain.ParticipantsResponse;
import alexiuscrow.epl.domain.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by Alexiuscrow on 30.08.2015.
 */
public class WSClient {
    public static final Long CLIENT_ID;
    public static final String SCOPE;
    public static final String AUTH_REDIRECT_URL;
    public static final String AUTH_DISPLAY_TYPE;
    public static final String AUTH_RESPONSE_TYPE;
    public static final String API_VERSION;
    public static final String AUTH_URL;

    private static Client client;
    private static final Logger LOGGER = LoggerFactory.getLogger(WSClient.class);

    private static String token;

    static {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            try {
                input = WSClient.class.getResourceAsStream("/properties/ws.properties");
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            CLIENT_ID = Long.valueOf(prop.getProperty("CLIENT_ID"));
            SCOPE = prop.getProperty("SCOPE");
            AUTH_REDIRECT_URL = prop.getProperty("AUTH_REDIRECT_URL");
            AUTH_DISPLAY_TYPE = prop.getProperty("AUTH_DISPLAY_TYPE");
            AUTH_RESPONSE_TYPE = prop.getProperty("AUTH_RESPONSE_TYPE");
            API_VERSION = prop.getProperty("API_VERSION");

            AUTH_URL = String.format("https://oauth.vk.com/authorize?client_id=%s&display=%s&redirect_uri=%s&scope=%s&response_type=%s&v=%s",
                    CLIENT_ID, AUTH_DISPLAY_TYPE, AUTH_REDIRECT_URL, SCOPE, AUTH_RESPONSE_TYPE, API_VERSION);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error("!!!", e);
                }
            }
        }

        client = ClientBuilder.newClient();
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        WSClient.token = token;
    }

    public static ParticipantsResponse getAllMembers(List<Long> listenedEventsIds) {
        if (listenedEventsIds == null || listenedEventsIds.size() == 0)
            return null;

        ParticipantsResponse result = new ParticipantsResponse();
        ParticipantsResponse participantsResponse;

        for (Long eventId: listenedEventsIds) {
            if (eventId == null)
                break;

            WebTarget target = client.target("https://api.vk.com/method").path("users.search")
                    .queryParam("group_id", eventId)
                    .queryParam("city", Settings.getParticipantFilterCondition().getCity())
                    .queryParam("country", Settings.getParticipantFilterCondition().getCountry())
                    .queryParam("count", "1000")
                    .queryParam("age_from", Settings.getParticipantFilterCondition().getAge())
                    .queryParam("fields", "country,city,photo_50,photo_100,can_write_private_message,online")
                    .queryParam("access_token", getToken());

            LOGGER.debug("Get all members. Request url: " + target.getUri());

            participantsResponse = target.request().get(ParticipantsResponse.class);

            result.addParticipants(participantsResponse.getParticipants());
        }

        LOGGER.info(String.format("Got %d participants", result.getCount()));

        return result;
    }

    public static Profile getProfile(Long uid) {
        if (uid == null)
            return null;

        Profile profile;

        WebTarget target = client.target("https://api.vk.com/method").path("users.get")
                .queryParam("user_ids", uid)
                .queryParam("fields", "photo_50")
                .queryParam("access_token", getToken());

        LOGGER.debug("Get profile. Request url: " + target.getUri());

        LOGGER.debug("\t" + target.request().get(String.class));
        profile = target.request().get(Profile.class);

        return profile;
    }
}
