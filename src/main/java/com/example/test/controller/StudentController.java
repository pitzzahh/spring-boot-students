package com.example.test.controller;


import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/students/")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{studentName}")
    public Optional<Student> findStudentByName(@PathVariable("studentName") String name) {
        return studentService.findStudentByName(name);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{personId}")
    public void deleteStudent(@PathVariable("personId") Long studentId) {
        studentService.deleteStudentById(studentId);
    }
}
