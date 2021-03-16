import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by bahubali.n on 14/03/17.
 */
public class BonusAllocation {


    public static Team<Employee> allocate(Team<Employee> team, double bonusAmount) {
        Stack<Team<Employee>> employeeStack = new Stack<Team<Employee>>();
        employeeStack.push(team);
        Map<Team<Employee>, Double> visitedEmployee = new HashMap<Team<Employee>, Double>();
        visitedEmployee.put(team, bonusAmount);
        while (!employeeStack.empty()) {
            Team<Employee> member = employeeStack.peek();
            boolean found = false;
            if (member.hasTeamMembers()) {
                float totalRating = member.getTotalTeamRating();
                for (Team<Employee> employee: member.getTeamMembers()) {
                    if (!visitedEmployee.containsKey(employee)) {
                        double teamBonus = (employee.getEmployee().getRating()/totalRating)*visitedEmployee.get(member);
                        visitedEmployee.put(employee, teamBonus);
                        employeeStack.push(employee);
                        found = true;
                    }
                }
            } else{
                member.getEmployee().setBonusAmount(visitedEmployee.get(member));
            }
            if (!found) {
                employeeStack.pop();
            }
        }
        return team;
    }
    public static void main(String[] args) throws Exception {
        Team<Employee> orgStructure = new Team<Employee>();
        Employee ceo = new Employee(10, 0, 4);
        orgStructure.setEmployee(ceo);

        Team<Employee> employee1 = new Team(new Employee(16, 13, 2));
        Team<Employee> employee2 = new Team(new Employee(17, 13, 2));
        Team<Employee> employee3 = new Team(new Employee(18, 14, 2));
        Team<Employee> employee4 = new Team(new Employee(19, 14, 2));
        Team<Employee> employee5 = new Team(new Employee(20, 15, 2));
        Team<Employee> employee6 = new Team(new Employee(21, 15, 2));
        Team<Employee> manager1 = new Team(new Employee(13, 11, 2));
        Team<Employee> manager2 = new Team(new Employee(14, 12, 2));
        Team<Employee> manager3 = new Team(new Employee(15, 12, 2));

        manager1.addTeamMember(employee1);
        manager1.addTeamMember(employee2);
        manager2.addTeamMember(employee3);
        manager2.addTeamMember(employee4);
        manager3.addTeamMember(employee5);
        manager3.addTeamMember(employee6);
        Team<Employee> director1 = new Team(new Employee(11, 10, 3));
        Team<Employee> director2 = new Team(new Employee(12, 10, 3));
        director1.addTeamMember(manager1);
        director2.addTeamMember(manager2);
        director2.addTeamMember(manager3);
        orgStructure.addTeamMember(director1);
        orgStructure.addTeamMember(director2);
        double bonus = 100000;
        orgStructure = BonusAllocation.allocate(orgStructure, bonus);


    }
}