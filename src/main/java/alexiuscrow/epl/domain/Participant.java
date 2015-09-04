package alexiuscrow.epl.domain;

import java.net.URI;
import java.net.URL;

/**
 * Created by Alexiuscrow on 30.08.2015.
 */
public class Participant {
    private Long id;
    private URI avatar;
    private URL userPageURL;
    private String fullName;
    private Boolean invited;
    private Boolean online;

    public Participant() {}

    public Participant(Long id, URI avatar, URL userPageURL, String fullName, Boolean invited, Boolean online) {
        this.id = id;
        this.avatar = avatar;
        this.userPageURL = userPageURL;
        this.fullName = fullName;
        this.invited = invited;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URI getAvatar() {
        return avatar;
    }

    public void setAvatar(URI avatar) {
        this.avatar = avatar;
    }

    public URL getUserPageURL() {
        return userPageURL;
    }

    public void setUserPageURL(URL userPageURL) {
        this.userPageURL = userPageURL;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean isInvited() {
        return invited;
    }

    public void setInvited(Boolean invited) {
        this.invited = invited;
    }

    public Boolean isOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", avatar=" + avatar +
                ", userPageURL=" + userPageURL +
                ", fullName='" + fullName + '\'' +
                ", invited=" + invited +
                ", online=" + online +
                '}';
    }
}
