package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "STUDENT_COLLEGE")
public class StudentCollege {


    @OneToMany(mappedBy = "studentCollege", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Id
    @GeneratedValue
    @Column(name = "college_id")
    private Long college_id;

    public Long getCollege_id() {
        return college_id;
    }

    public void setCollege_id(Long college_id) {
        this.college_id = college_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    @Column(name = "college_name")
    private String college_name;
}
