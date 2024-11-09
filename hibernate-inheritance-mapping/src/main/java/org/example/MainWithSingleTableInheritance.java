package org.example;

import org.example.single_table_inheritance.Car;
import org.example.single_table_inheritance.Truck;
import org.example.single_table_inheritance.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class MainWithSingleTableInheritance
{
    public static void main(String[] args)
    {
        System.out.printf("Hello and welcome!");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        // INSERT START
        Car car = new Car();
        car.setManufacturer("Toyota");
        car.setSeatingCapacity(4);

        Truck truck = new Truck();
        truck.setManufacturer("Tata");
        truck.setPayloadCapacity(100);

        session.save(car);
        session.save(truck);

        session.getTransaction().commit();
        // INSERT END

        // FETCH START
        List<Vehicle> vehicles = session.createQuery("from Vehicle", Vehicle.class).list();
        for (Vehicle vehicle : vehicles)
        {
            System.out.println("Vehicle ID: " + vehicle.getId() + ", Brand: " + vehicle.getManufacturer());
        }
        // FETCH END

        // UPDATE START
        /*Vehicle vehicle = session.get(Vehicle.class, 2L);
        if (vehicle != null)
        {
            vehicle.setManufacturer("Mahindra");
            session.update(vehicle);
        }
        session.getTransaction().commit();*/
        // UPDATE END

        // DELETE START
        /*Vehicle vehicle = session.get(Vehicle.class, 2L);
        if (vehicle != null)
        {
            session.delete(vehicle);
        }

        session.getTransaction().commit();*/
        // DELETE END

        session.close();
    }
}
