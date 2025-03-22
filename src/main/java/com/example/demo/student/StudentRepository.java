package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repository is a layer in our application responsible for data access. It provides
// an abstraction over the database, making it easier to perform CRUD operations without directly
// writing SQL queries. Student -> the entity class, Long -> The type of primary key.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

