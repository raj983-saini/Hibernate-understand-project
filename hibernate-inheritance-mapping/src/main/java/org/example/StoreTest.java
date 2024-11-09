package org.example;

import org.example.withannotation.Contract_Employee;
import org.example.withannotation.Employee;
import org.example.withannotation.Regular_Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreTest {

    public static void main(String args[])
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        Transaction t=session.beginTransaction();

        Employee e1=new Employee();
        e1.setName("Ashwin");

        Regular_Employee e2=new Regular_Employee();
        e2.setName("Aman");
        e2.setSalary(65000);
        e2.setBonus(3);

        Contract_Employee e3=new Contract_Employee();
        e3.setName("Ankit");
        e3.setPay_per_hour(1500);
        e3.setContract_duration("8 hours");

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);

        t.commit();
        session.close();
        System.out.println("success");
    }
}
