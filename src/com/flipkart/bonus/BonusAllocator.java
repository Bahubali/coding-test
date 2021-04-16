package com.flipkart.bonus;

import java.math.BigDecimal;
import java.util.*;

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

    public static void print(Employee employee) {
        Deque<Employee> queue = new ArrayDeque<>();
        queue.push(employee);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Employee current = queue.poll();
                System.out.print(current.getId()+" ");
                if (current.hasMembers()) {
                    for (Employee member : current.getTeamMembers()) {
                        queue.add(member);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Employee ceo = new Employee(1, 1000000.00, 0.0d, Designation.CEO);
        Employee manager1 = new Employee(2, 10000.00, 0.0d, Designation.MANAGER);
        Employee manager2 = new Employee(3, 40000.00, 0.0d, Designation.MANAGER);
        Employee manager3 = new Employee(4, 70000.00, 0.0d, Designation.MANAGER);
        ceo.addMember(manager1);
        ceo.addMember(manager2);
        ceo.addMember(manager3);

        Employee developer1 = new Employee(5, 1000.00, 2.9, Designation.DEVELOPER);
        Employee developer2 = new Employee(6, 3000.00, 3.5, Designation.DEVELOPER);
        Employee developer3 = new Employee(7, 4000.00, 3.1, Designation.DEVELOPER);

        Employee developer4 = new Employee(8, 7000.00, 4.2, Designation.DEVELOPER);
        Employee developer5 = new Employee(9, 3500.00, 4.9, Designation.DEVELOPER);
        Employee developer6 = new Employee(10, 5000.00, 3.3, Designation.DEVELOPER);

        manager1.addMember(developer1);
        manager1.addMember(developer2);
        manager1.addMember(developer3);
        manager2.addMember(developer4);
        manager2.addMember(developer5);
        manager3.addMember(developer6);
        OrgStructure orgStructure = new OrgStructure(ceo);
        BonusAllocator.allocate(ceo, 100000.0d);
        System.out.println("Print the org heirarchy");
        orgStructure.printOrgHierarchy();
    }
}
