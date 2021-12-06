package com.example.university.service;

import com.example.university.model.domain.Student;
import com.example.university.model.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface StudentService {

    Page<Student> getPageOfStudent(Pageable pageable, Specification specification);

    List<Student> getListOfStudent();

    void createStudent(StudentDTO studentDTO);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudent(long id);

}
