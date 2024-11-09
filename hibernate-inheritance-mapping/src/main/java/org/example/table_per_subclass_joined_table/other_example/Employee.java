package org.example.table_per_subclass_joined_table.other_example;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {
    private String department;

    // Getters and Setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

