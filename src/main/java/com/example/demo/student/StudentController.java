package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // // Marks this class as a REST API controller that serves endpoints
@RequestMapping(path = "api/v1/student") // Maps requests to /api/v1/student to this controller
public class StudentController {
    private final StudentService studentService;

    @Autowired // Spring automatically injects the StudentService bean into this class
    // Since we marked StudentService with @Service (a specialized @Component),
    // it becomes a Spring-managed bean and gets instantiated by Spring.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // notes:
    // 1. Spring scans for @Component (or @Service, @Repository, etc.) annotations.
    // 2. Spring creates objects (beans) for these classes automatically.
    // 3. When another class needs one of these beans, it injects the pre-initialized object using @Autowired.
    // 4. This avoids manual instantiation (new ClassName()) and allows Spring to manage dependencies efficiently.

    @GetMapping // Handles HTTP GET requests to /api/v1/student
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
