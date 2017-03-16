import java.util.*;

/**
 * Created by bahubali.n on 16/03/17.
 */
public class Country {
    int countryId;
    String friend;
    List<Country> linkedCountries;


    public Country(int countryId, String friend) {
        this.countryId = countryId;
        this.friend = friend;
        linkedCountries = new ArrayList<Country>();
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<Country> getLinkedCountries() {
        return linkedCountries;
    }

    public void setLinkedCountries(List<Country> linkedCountries) {
        this.linkedCountries = linkedCountries;
    }

    public boolean hasCountries() {
        return (this.linkedCountries.size() > 0);
    }
}
