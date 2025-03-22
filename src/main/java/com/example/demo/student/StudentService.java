package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> StudentOptional = studentRepository.findStudentByEmail(student.getEmail());
        System.out.println("updating student");
        if(StudentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        };
        System.out.println("updating student");
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
