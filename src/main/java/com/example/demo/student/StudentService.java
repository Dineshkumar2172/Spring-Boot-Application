package com.example.demo.student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class StudentService {
    public List<Student> getStudents() {
        return List.of(new Student(
                "dinesh@gmail.com",
                LocalDate.of(2000, 7, 21),
                25,
                876890,
                "dinesh"
        ));
    }
}
