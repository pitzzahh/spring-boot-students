package com.example.test.service;

import com.example.test.entity.Student;
import com.example.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentByName(String name) {
        Objects.requireNonNull(name, "name should not be null");
        return studentRepository.findStudentByName(name).get();
    }

    public void addStudent(Student student) {
        Objects.requireNonNull(student, "Student cannot be null");
        studentRepository.save(student);
    }

    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

}
