package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
    1. Relations with annotations
    2. collection mapping with annotation
    3. inheritance with annotation

    1. HQL
    2. Cache with annotation
    3. xml mapping



 */

public class Main {
    public static void main(String[] args)
    {
        System.out.printf("Hello and welcome!");
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        session.close();
        System.out.println("success");
    }
}