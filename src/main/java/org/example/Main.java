package org.example;

import jakarta.persistence.Persistence;
import org.example.entities.Student;

import org.example.entities.StudentDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        //config.configure();
        //config.configure();
        config.addAnnotatedClass(org.example.entities.Student.class);
        config.addAnnotatedClass(org.example.entities.StudentDetails.class);


        SessionFactory sf = config.buildSessionFactory();
        Session s = sf.openSession();

        try{
            s.beginTransaction();

            StudentDetails yashDetails = new StudentDetails();
            yashDetails.setZipCode(123456);

            Student yash = new Student();
            yash.setStudentName("Yash");
            yash.setStudentDetail(yashDetails);


            yashDetails.setStudent(yash);

            s.persist(yash);

            s.persist(yashDetails);

            s.getTransaction().commit();
        }
        finally {
            s.close();
            sf.close();
        }



    }
}