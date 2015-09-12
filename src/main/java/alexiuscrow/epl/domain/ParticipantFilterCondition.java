package alexiuscrow.epl.domain;

/**
 * Created by Alexiuscrow on 12.09.2015.
 */
public class ParticipantFilterCondition {
    private Long age;
    private Long city;
    private Long country;

    public ParticipantFilterCondition() {}

    public ParticipantFilterCondition(Long age, Long city, Long country) {
        this.age = age;
        this.city = city;
        this.country = country;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
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
}
