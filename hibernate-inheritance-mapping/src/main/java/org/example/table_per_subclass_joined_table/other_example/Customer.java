package org.example.table_per_subclass_joined_table.other_example;

import javax.persistence.Entity;

@Entity
public class Customer extends Person {
    private String coursePurchased;

    public String getCoursePurchased() {
        return coursePurchased;
    }

    public void setCoursePurchased(String coursePurchased) {
        this.coursePurchased = coursePurchased;
    }
}

