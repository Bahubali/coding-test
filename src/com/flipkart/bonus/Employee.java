package com.flipkart.bonus;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Employee {

    private int id;
    private Double salary;
    private Double bonus;
    private Double rating;
    private Designation designation;
    private List<Employee> teamMembers;

    Employee(int id, Double salary, Double rating, Designation designation) {
        this.id = id;
        this.salary = salary;
        this.rating = rating;
        this.designation = designation;
        this.teamMembers = new LinkedList<>();
    }

    /**
     * Add team member
     *
     * @param employee
     */
    public void addMember(Employee employee) {
        int size = this.teamMembers.size();
        if (this.teamMembers != null)
            this.teamMembers.add(employee);

        this.rating = (this.rating * size + employee.getRating())/this.teamMembers.size();
    }

    public Employee getMember(int employeeId) {
        for (Employee employee1: this.teamMembers) {
            if (employee1.getId() == employeeId) return employee1;
        }
        return null;
    }

    public Double getTotalRating() {
        Double ratingSum = 0.0d;
        if (hasMembers()) {
            for (Employee member: this.teamMembers)
                ratingSum += member.getRating();
        }
        return ratingSum;
    }

    public boolean hasMembers() {
        return !this.teamMembers.isEmpty();
    }

}
