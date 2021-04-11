package com.flipkart.bonus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class BonusAllocator {

    public static void allocate(Employee employee, Double bonus) {
        Stack<Employee> employeeStack = new Stack<>();
        employeeStack.push(employee);
        Map<Integer, Employee> visited = new HashMap<>();
        employee.setBonus(bonus);
        visited.put(employee.getId(), employee);
        while (!employeeStack.isEmpty()) {
            if (employeeStack.peek().hasMembers()) {
                Employee current = employeeStack.pop();
                Double totalRating = current.getTotalRating();
                for (Employee member: current.getTeamMembers()) {
                    BigDecimal bonusByPercent = BigDecimal.valueOf((member.getRating() / totalRating) * 100);
                    Double allocated = bonusByPercent.divide(BigDecimal.valueOf(100))
                            .multiply(BigDecimal.valueOf(current.getBonus())).doubleValue();
                    member.setBonus(allocated);
                    employeeStack.push(member);
                }
            } else {
                if (!employeeStack.isEmpty()) employeeStack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Employee ceo = new Employee(1, 0.0d, 0.0d, Designation.CEO);
        Employee manager1 = new Employee(2, 0.0d, 0.0d, Designation.MANAGER);
        Employee manager2 = new Employee(3, 0.0d, 0.0d, Designation.MANAGER);
        Employee manager3 = new Employee(4, 0.0d, 0.0d, Designation.MANAGER);
        ceo.addMember(manager1);
        ceo.addMember(manager2);
        ceo.addMember(manager3);

        Employee developer1 = new Employee(5, 0.0d, 2.9, Designation.DEVELOPER);
        Employee developer2 = new Employee(6, 0.0d, 3.5, Designation.DEVELOPER);
        Employee developer3 = new Employee(7, 0.0d, 3.1, Designation.DEVELOPER);

        Employee developer4 = new Employee(8, 0.0d, 4.2, Designation.DEVELOPER);
        Employee developer5 = new Employee(9, 0.0d, 4.9, Designation.DEVELOPER);
        Employee developer6 = new Employee(10, 0.0d, 3.3, Designation.DEVELOPER);

        manager1.addMember(developer1);
        manager1.addMember(developer2);
        manager1.addMember(developer3);
        manager2.addMember(developer4);
        manager2.addMember(developer5);
        manager3.addMember(developer6);
        BonusAllocator.allocate(ceo, 100000.0d);
        System.out.println("Allocated bonus");
    }
}
