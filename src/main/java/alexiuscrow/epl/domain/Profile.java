package alexiuscrow.epl.domain;

import alexiuscrow.epl.utils.ProfileDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Created by Alexiuscrow on 13.09.2015.
 */
@JsonDeserialize(using = ProfileDeserializer.class)
public class Profile {
    private Long uid;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String urlPhoto20;
    @JsonProperty("photo_50")
    private String urlPhoto50;

    public Long getUid() {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    public String getUrlPhoto20() {
        return this.urlPhoto20;
    }

    public void setUrlPhoto20(String urlPhoto20) {
        this.urlPhoto20 = urlPhoto20;
    }

    public String getUrlPhoto50() {
        return this.urlPhoto50;
    }

    public void setUrlPhoto50(String urlPhoto50) {
        this.urlPhoto50 = urlPhoto50;
    }
    
}
