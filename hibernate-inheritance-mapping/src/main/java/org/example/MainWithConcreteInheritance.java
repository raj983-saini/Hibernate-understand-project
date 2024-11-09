package org.example;

import org.example.table_per_concrete_inheritance.CarTPC;
import org.example.table_per_concrete_inheritance.TruckTPC;
import org.hibernate.Session;

import java.util.List;

public class MainWithConcreteInheritance
{
    public static void main(String[] args)
    {

        System.out.printf("Hello and welcome!");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // INSERT START
        /*CarTPC carTPC = new CarTPC();
        carTPC.setManufacturer("Maruti");
        carTPC.setSeatingCapacity(5);

        TruckTPC truckTPC = new TruckTPC();
        truckTPC.setManufacturer("Tata");
        truckTPC.setPayloadCapacity(150);

        session.save(carTPC);
        session.save(truckTPC);

        session.getTransaction().commit();*/
        // INSERT END

        // FETCH START
        List<CarTPC> carTPCS = session.createQuery("from CarTPC", CarTPC.class).list();
        List<TruckTPC> truckTPCS = session.createQuery("from TruckTPC", TruckTPC.class).list();

        System.out.println("Cars: ");
        for (CarTPC carTPC : carTPCS) {
            System.out.println("ID: " + carTPC.getId() + ", Manufacture: " + carTPC.getManufacturer() + ", Capacity: " + carTPC.getSeatingCapacity());
        }

        System.out.println("Truck: ");
        for (TruckTPC truckTPC : truckTPCS) {
            System.out.println("ID: " + truckTPC.getId() + ", Manufacture: " + truckTPC.getManufacturer() + ", payload: " + truckTPC.getPayloadCapacity());
        }
        // FETCH END

        // UPDATE START
        /*TruckTPC truckTPC = session.get(TruckTPC.class, 2L);
        if (truckTPC != null)
        {
            truckTPC.setPayloadCapacity(230);
            session.update(truckTPC);
        }

        session.getTransaction().commit();*/
        // UPDATE END

        // DELETE START
        TruckTPC truckTPC = session.get(TruckTPC.class, 2L);
        if (truckTPC != null) {
            session.delete(truckTPC);
        }

        session.getTransaction().commit();
        // DELETE END

        session.close();

    }
}
