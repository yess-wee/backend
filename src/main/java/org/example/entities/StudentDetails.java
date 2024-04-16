package org.example.entities;

import jakarta.persistence.*;

@Entity
public class StudentDetails {

    @Id
    @GeneratedValue
    @Column(name = "SDID")
    int sdid;

    @Column(name = "ZIPCODE")
    int zipCode;

    public int getSdid() {
        return sdid;
    }

    public void setSdid(int sdid) {
        this.sdid = sdid;
    }

    @OneToOne(mappedBy = "studentDetails", cascade = CascadeType.ALL)
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}