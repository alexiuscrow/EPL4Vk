package alexiuscrow.epl.domain;

import java.net.URL;

/**
 * Created by Alexiuscrow on 30.08.2015.
 */
public class Participant {

    private URL imageURL;
    private URL userPageURL;
    private String fullName;
    private Boolean called;

    public URL getImageURL() {
        return imageURL;
    }

    public void setImageURL(URL imageURL) {
        this.imageURL = imageURL;
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

    public Boolean getCalled() {
        return called;
    }

    public void setCalled(Boolean called) {
        this.called = called;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "imageURL=" + imageURL +
                ", userPageURL=" + userPageURL +
                ", fullName='" + fullName + '\'' +
                ", called=" + called +
                '}';
    }
}
