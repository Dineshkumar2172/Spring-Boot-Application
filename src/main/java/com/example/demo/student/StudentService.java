package com.example.demo.student;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateStudent(long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student id " + studentId + " does not exist"));

        if (name != null && !name.isEmpty()
                && !Objects.equals(student.getName(), name)) { // using Objects.equals since it's non-primitive datatype
            student.setName(name);
        }

        if (email != null && !email.isEmpty()
                && !Objects.equals(student.getEmail(), email)) { // using Objects.equals since it's non-primitive datatype
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
