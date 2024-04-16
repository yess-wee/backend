package org.example;

import jakarta.persistence.Persistence;
import org.example.entities.Student;

import org.example.entities.StudentCollege;
import org.example.entities.StudentDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        //config.configure();
        //config.configure();
        config.addAnnotatedClass(org.example.entities.Student.class);
       // config.addAnnotatedClass(org.example.entities.StudentDetails.class);

        config.addAnnotatedClass(org.example.entities.StudentCollege.class);


        SessionFactory sf = config.buildSessionFactory();
        Session s = sf.openSession();

        try{
            s.beginTransaction();
//------------------------------------------------------------------------------
//            StudentDetails kamaliDetails = new StudentDetails();
//            kamaliDetails.setZipCode(789012);
//
//            Student kamali = new Student();
//            kamali.setStudentName("Kamali");
//            kamali.setStudentDetail(kamaliDetails);
//
//
//            kamaliDetails.setStudent(kamali);
//
//            s.persist(kamali);
//
//            s.persist(kamaliDetails);
//-------------------------------------------------------------------------

            Student yashvi = new Student();
            Student raam = new Student();
            Student seeta = new Student();

            yashvi.setStudentName("Yashvi");
            raam.setStudentName("Raam");
            seeta.setStudentName("Seeta");

            StudentCollege ddu = new StudentCollege();
            StudentCollege iitb = new StudentCollege();

            ddu.setCollege_name("DDU");
            iitb.setCollege_name("IIT-B");


            yashvi.setStudentCollege(ddu);
            raam.setStudentCollege(iitb);
            seeta.setStudentCollege(iitb);


            //add list to implement bidirectional --- StudentCollege -- check also

            List dduStudents = new ArrayList();
            List iitbStudents = new ArrayList();

            dduStudents.add(yashvi);
            iitbStudents.add(raam);
            iitbStudents.add(seeta);

            ddu.setStudents(dduStudents);
            iitb.setStudents(iitbStudents);

//            s.persist(yashvi);
//            s.persist(raam);
//            s.persist(seeta);

            s.persist(ddu);
            s.persist(iitb);

            s.getTransaction().commit();
        }
        finally {
            s.close();
            sf.close();
        }



    }
}