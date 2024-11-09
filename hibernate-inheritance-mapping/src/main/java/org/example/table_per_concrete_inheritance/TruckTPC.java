package org.example.table_per_concrete_inheritance;

import javax.persistence.*;
@Entity
public class TruckTPC extends VehicleTPC {
    @Column(name = "payload_capacity")
    private double payloadCapacity;

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }
}
