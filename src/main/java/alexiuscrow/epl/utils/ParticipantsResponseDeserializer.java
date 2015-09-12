package alexiuscrow.epl.utils;

import alexiuscrow.epl.domain.Participant;
import alexiuscrow.epl.domain.ParticipantsResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexiuscrow on 12.09.2015.
 */
public class ParticipantsResponseDeserializer extends JsonDeserializer<ParticipantsResponse> {
    @Override
    public ParticipantsResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(p);
        JsonNode response = node.get("response");

        Long count = 0L;
        List<Participant>  participants = new ArrayList<Participant>();

        if (response.isArray()) {
            count = response.get(0).asLong();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            for (int i = 1; i < response.size(); i++) {
                participants.add(mapper.treeToValue(response.get(i), Participant.class));
            }
        }

        return new ParticipantsResponse(count, participants);
    }
}
