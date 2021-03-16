import java.util.HashMap;
import java.util.Map;

/**
 * Created by bahubali.n on 15/02/17.
 */
public class ContractTest {
    public static void main(String[] args) {
        Map<EmployeeKey, String> cache = loadCache();
        EmployeeKey lookUpKey = new EmployeeKey("103", "13101988");
        //int h = lookUpKey.hashCode();
        //h = h ^ (h >>> 16);
        System.out.println(cache.toString());
    }

    public static Map<EmployeeKey, String> loadCache() {
        EmployeeKey ek1 = new EmployeeKey("101", "10101988");
        EmployeeKey ek2 = new EmployeeKey("102", "12101988");
        EmployeeKey ek3 = new EmployeeKey("103", "13101988");
        Map<EmployeeKey, String> cache = new HashMap<EmployeeKey, String>();
        cache.put(ek1, "Bahubali");
        cache.put(ek2, "Anand");
        cache.put(ek3, "Sachin");

        return cache;
    }
}

class EmployeeKey
{
    String empId;
    String dob;

    public EmployeeKey(String theId, String theDob) {
        empId = theId;
        dob = theDob;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        EmployeeKey that = (EmployeeKey) o;
//
//        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
//        return dob != null ? dob.equals(that.dob) : that.dob == null;
//
//    }
}
