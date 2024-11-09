package org.example.single_table_inheritance;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {
    @Column(name = "seating_capacity")
    private int seatingCapacity;

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
