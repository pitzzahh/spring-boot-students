package com.example.test.repository;

import com.example.test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.function.Supplier;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Supplier<Optional<Student>> findStudentByName(String name);
}
