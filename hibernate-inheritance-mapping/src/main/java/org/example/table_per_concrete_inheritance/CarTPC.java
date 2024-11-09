package org.example.table_per_concrete_inheritance;

import javax.persistence.*;
@Entity
public class CarTPC extends VehicleTPC {
    @Column(name = "seating_capacity")
    private int seatingCapacity;

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
