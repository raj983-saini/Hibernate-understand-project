package org.example;

import org.example.table_per_subclass_joined_table.other_example.Customer;
import org.example.table_per_subclass_joined_table.other_example.Employee;
import org.hibernate.Session;

import java.util.List;

public class MainWithSubclassJoined
{
    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        /*Employee employee = new Employee();
        employee.setName("Deepti Madam");
        employee.setDepartment("Sales Executive");

        Customer customer = new Customer();
        customer.setName("Ashish");
        customer.setCoursePurchased("Java Full Stack");

        session.save(employee);
        session.save(customer);

        session.getTransaction().commit();*/

        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();

        System.out.println("Employees:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Department: " + employee.getDepartment());
        }

        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId() + ", Name: " + customer.getName() + ", Course Purchased: " + customer.getCoursePurchased());
        }

        /*Employee employee = session.get(Employee.class, 1L);
        if (employee != null) {
            employee.setName("rohan");
            session.update(employee);
        }

        session.getTransaction().commit();*/

        /*Employee employee = session.get(Employee.class, 1L);
        if (employee != null) {
            session.delete(employee);
        }
        session.getTransaction().commit();*/


        session.close();
    }
}
