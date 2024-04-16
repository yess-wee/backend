package org.example.entities;

import jakarta.persistence.*;
@Entity
public class Student {

    @Id @GeneratedValue @Column(name = "SID")
    private int studentId;

    @Column(name = "SNAME")
    private String studentName;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "stud_fk")
    private StudentDetails studentDetails;

    public StudentDetails getStudentDetail() {
        return studentDetails;
    }

    public void setStudentDetail(StudentDetails studentDetail) {
        this.studentDetails = studentDetail;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}