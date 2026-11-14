package com.example.student_manager.Repository;

import com.example.student_manager.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsByEmail(String email);
    boolean existsByEmaliAndIdNot(String email,Long id);
}
