package com.example.student_manager.Service;

import com.example.student_manager.Entity.Student;
import com.example.student_manager.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository){
        this.repository=repository;
    }
    public List<Student> findAll(){
        return repository.findAll();
    }
    public Optional<Student>findById(Long id){
        return repository.findById(id);
    }
    public Student save(Student student){
        return repository.save(student);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public boolean emailExists(String email, Long excludedId){
        return excludedId==null
                ?repository.existsByEmail(email)
                :repository.existsByEmaliAndIdNot(email,excludedId);
    }
}
