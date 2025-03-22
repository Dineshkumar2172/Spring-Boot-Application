package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table // mapped our student class to table in our database
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;

    @Transient // marking it prevents a field from being serialized when an object is converted into a byte stream.
    // Some fields, like passwords, sensitive data, or large cache fields, should not be stored or transmitted.
    // Using transient ensures these fields are ignored during serialization.
    private Integer age;

    private LocalDate dob;
    private String email;

    public Student() {}

    public Student(String email, LocalDate dob, long id, String name) {
        this.email = email;
        this.dob = dob;
        this.id = id;
        this.name = name;
    }

    public Student(String email, LocalDate dob, String name) {
        this.email = email;
        this.dob = dob;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
