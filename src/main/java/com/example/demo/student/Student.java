package com.example.demo.student;

import java.time.LocalDate;

public class Student {
    private long id;
    private String name;
    private Integer age;
    private LocalDate dob;
    private String email;

    public Student() {}

    public Student(String email, LocalDate dob, Integer age, long id, String name) {
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public Student(String email, LocalDate dob, Integer age, String name) {
        this.email = email;
        this.dob = dob;
        this.age = age;
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
        return age;
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
