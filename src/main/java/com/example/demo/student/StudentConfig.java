package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean // CommandLineRunner is a special Spring interface that executes logic on application startup.
    CommandLineRunner commandLineRunner (StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student(
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 12),
                    26,
                    "Mariam"
            );

            Student dinesh = new Student(
                    "dinesh.kumar@gmail.com",
                    LocalDate.of(2000, Month.JULY, 21),
                    26,
                    "Dinesh"
            );

            studentRepository.saveAll(List.of(mariam, dinesh));
        };
    }
}
