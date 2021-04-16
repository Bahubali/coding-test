package com.flipkart.bonus;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class OrgStructure {

    private Employee orgHierarchy;
    private Map<Integer, Employee> employeeMap;

    OrgStructure(Employee root) {
        this.orgHierarchy = root;
        this.employeeMap = new HashMap<>();
        this.employeeMap.put(root.getId(), root);
    }

    public void assignMember(Integer managerId, Employee employee) {
        if (this.employeeMap.containsKey(managerId)) {
            Employee manager = this.employeeMap.get(managerId);
            manager.addMember(employee);
            this.employeeMap.put(employee.getId(), employee);
        }
    }

    public void printOrgHierarchy() {
        Deque<Employee> queue = new ArrayDeque<>();
        queue.push(this.orgHierarchy);
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
}
