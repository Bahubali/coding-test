import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bahubali.n on 14/03/17.
 */
public class Team<T> {
    public T teamHead;
    List<Team<T>> teamMembers;

    public Team() {
        super();
        teamMembers = new ArrayList<Team<T>>();
    }

    public Team(T employee) {
        this();
        setEmployee(employee);
        teamMembers = new ArrayList<Team<T>>();
    }

    public void setEmployee(T employee) {
        this.teamHead = employee;
    }

    public T getEmployee() {
        return this.teamHead;
    }

    public List<Team<T>> getTeamMembers() {
        return this.teamMembers;
    }

    public boolean hasTeamMembers() {
        return (this.teamMembers.size() > 0);
    }

    public void addTeamMember(Team<T> member) {
        this.teamMembers.add(member);
    }

    public float getTotalTeamRating() {
        float totalRating = 0;
        Iterator iterator = teamMembers.iterator();
        while (iterator.hasNext()) {
            Team<Employee> member = (Team<Employee>) iterator.next();
            totalRating += member.getEmployee().getRating();
        }
        return totalRating;
    }
}
