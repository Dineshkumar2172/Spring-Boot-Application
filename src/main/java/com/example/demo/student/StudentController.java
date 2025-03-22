package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController // note: rest controller annotation makes this class to serve rest endpoints
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @GetMapping
    public List<Student> hello() {
        return List.of(new Student(
                "dinesh@gmail.com",
                LocalDate.of(2000, 7, 21),
                25,
                876890,
                "dinesh"
        ));
    }
}
