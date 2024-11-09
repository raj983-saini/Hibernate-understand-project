package org.example.single_table_inheritance;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Truck")
public class Truck extends Vehicle {
    @Column(name = "payload_capacity")
    private double payloadCapacity;

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }
}
