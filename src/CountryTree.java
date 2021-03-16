/**
 * Created by bahubali.n on 16/03/17.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class CountryTree {
    Country root;

    public CountryTree(Country root) {
        this.root = root;
    }

    public Country searchCountry(Integer countryId) {
        Country from = root;
        Stack<Country> stack = new Stack<Country>();
        stack.push(from);
        Country found = null;
        while (!stack.empty()) {
            found = stack.peek();
            if (countryId.equals(found.getCountryId())) return found;
            else {
                if (found.hasCountries()) {
                    stack.pop();
                    for (Country country: found.getLinkedCountries()) {
                        stack.push(country);
                    }
                } else {
                    stack.pop();
                }
            }
        }
        return found;
    }

    public void addCountry(Integer toCountryId, Country newCountry) throws Exception {
        Country toCountry = searchCountry(toCountryId);
        if (toCountry == null) throw new Exception("Country doesn't exist ");
        toCountry.getLinkedCountries().add(newCountry);
    }

    public int findNearestCountryWhereFriendStayingIn() {
        Country found = null;
        Country fromCountry = root;
        Queue<Country> countryQueue = new LinkedList<Country>();
        countryQueue.add(fromCountry);
        int countryId = Integer.MAX_VALUE;
        while (!countryQueue.isEmpty() & countryId <= Integer.MAX_VALUE) {
            Country current = countryQueue.peek();
            if (current.hasCountries()) {
                countryQueue.poll();
                for (Country country : current.getLinkedCountries()) {
                    countryQueue.add(country);
                }
            } else {
                if (current.getCountryId() < countryId)
                    countryId = current.getCountryId();
                countryQueue.poll();

            }
        }
        return countryId;
    }


    public static void main(String[] args) throws Exception {
        CountryTree countryTree = new CountryTree(new Country(1, "John"));
        countryTree.addCountry(1, new Country(2, null));
        countryTree.addCountry(1, new Country(3, "Mary"));
        countryTree.addCountry(1, new Country(4, "Lissa"));
        countryTree.addCountry(2, new Country(5, "Stanley"));
        countryTree.addCountry(2, new Country(6, "Mike"));
        countryTree.addCountry(3, new Country(7, "Laila"));
        System.out.println(countryTree.findNearestCountryWhereFriendStayingIn());
    }
}
