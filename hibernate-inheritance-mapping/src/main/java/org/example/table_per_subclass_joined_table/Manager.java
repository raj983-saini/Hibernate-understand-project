package org.example.table_per_subclass_joined_table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "employee_id")
public class Manager extends Employee
{

    @Column(name = "project_name")
    private double projectName;
}
