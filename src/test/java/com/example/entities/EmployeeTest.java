package com.example.entities;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeTest {

    @Test
    void createTableTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee1 = new Employee(null, "Yasar", "Chavez", "chavezyasar@gmail.com", 29, 100000d, true, LocalDate.of(1993,9,29), LocalDateTime.now());
        Employee employee2 = new Employee(null, "Victoria", "Longoni", "longonivictoria@gmail.com", 31, 200000d, true, LocalDate.of(1991,8,29), LocalDateTime.now());

        session.beginTransaction();

        session.persist(employee1);
        session.persist(employee2);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();

    }
    @Test
    void consultTableTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee = session.get(Employee.class, 1);

        System.out.println("EMPLEADO");
        System.out.println(employee);

        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();
    }
}
