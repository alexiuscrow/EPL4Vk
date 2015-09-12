package alexiuscrow.epl.domain;

import alexiuscrow.epl.utils.ParticipantsResponseDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

/**
 * Created by Alexiuscrow on 12.09.2015.
 */
@JsonDeserialize(using = ParticipantsResponseDeserializer.class)
public class ParticipantsResponse {
    @JsonProperty("count")
    private Long count;
    @JsonProperty("users")
    private List<Participant> participants;

    public ParticipantsResponse() {}

    public ParticipantsResponse(Long count, List<Participant> participants) {
        this.count = count;
        this.participants = participants;
    }

    public Long getCount() {
        return count;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    @JsonProperty("users")
    public void setParticipants(List<Participant> participants) {
        this.count = (long) participants.size();
        this.participants = participants;
    }

    public void addParticipants(List<Participant> participants) {
        if (participants != null && participants.size() != 0) {

            if (this.count == null)
                count = 0L;

            if (this.participants == null)
                this.participants = new ArrayList<Participant>();

            this.count += participants.size();
            this.participants.addAll(participants);
        }
    }

    @Override
    public String toString() {
        return "ParticipantsResponse{" +
                "count=" + count +
                ", participants=" + participants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantsResponse that = (ParticipantsResponse) o;

        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (participants != null ? !participants.equals(that.participants) : that.participants != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = count != null ? count.hashCode() : 0;
        result = 31 * result + (participants != null ? participants.hashCode() : 0);
        return result;
    }
}
