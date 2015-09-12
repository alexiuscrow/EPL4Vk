package alexiuscrow.epl.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Alexiuscrow on 30.08.2015.
 */
public class Participant {
    private Long uid;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private Long sex;
    private String domain;
    private Long city;
    private Long country;
    @JsonProperty("photo_50")
    private String urlPhoto50;
    @JsonProperty("photo_100")
    private String urlPhoto100;
    private Boolean online;
    @JsonProperty("can_write_private_message")
    private Boolean canWritePrivateMsg;
    private Boolean invited;

    public Participant() {}

    public Participant(Long uid, String firstName, String lastName, Long sex, String domain, Long city, Long country, String urlPhoto50, String urlPhoto100, Boolean online, Boolean canWritePrivateMsg, Boolean invited) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.domain = domain;
        this.city = city;
        this.country = country;
        this.urlPhoto50 = urlPhoto50;
        this.urlPhoto100 = urlPhoto100;
        this.online = online;
        this.canWritePrivateMsg = canWritePrivateMsg;
        this.invited = invited;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public String getUrlPhoto50() {
        return urlPhoto50;
    }

    public void setUrlPhoto50(String urlPhoto50) {
        this.urlPhoto50 = urlPhoto50;
    }

    public String getUrlPhoto100() {
        return urlPhoto100;
    }

    public void setUrlPhoto100(String urlPhoto100) {
        this.urlPhoto100 = urlPhoto100;
    }

    public Boolean isOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean canWritePrivateMsg() {
        return canWritePrivateMsg;
    }

    public void setCanWritePrivateMsg(Boolean canWritePrivateMsg) {
        this.canWritePrivateMsg = canWritePrivateMsg;
    }

    public Boolean isInvited() {
        return invited;
    }

    public void setInvited(Boolean invited) {
        this.invited = invited;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", domain='" + domain + '\'' +
                ", city=" + city +
                ", country=" + country +
                ", urlPhoto50='" + urlPhoto50 + '\'' +
                ", urlPhoto100='" + urlPhoto100 + '\'' +
                ", online=" + online +
                ", canWritePrivateMsg=" + canWritePrivateMsg +
                ", invited=" + invited +
                '}';
    }
}
