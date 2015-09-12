package alexiuscrow.epl.utils;

import alexiuscrow.epl.domain.Profile;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Alexiuscrow on 12.09.2015.
 */
public class ProfileDeserializer extends JsonDeserializer<Profile> {
    @Override
    public Profile deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(p);
        JsonNode response = node.get("response");
        JsonNode item = response.get(0);

        System.out.println("response: " + response);
        System.out.println("response.get(0): " + response.get(0));
        System.out.println("item: " + item);

        Profile profile = new Profile();
        profile.setUid(item.get("uid").asLong());
        profile.setFirstName(item.get("first_name").asText());
        profile.setLastName(item.get("last_name").asText());
        profile.setUrlPhoto50(item.get("photo_50").asText());

        System.out.println(profile);

        return profile;
    }
}
