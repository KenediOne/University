package com.example.university.service.impl;

import com.example.university.model.domain.Student;
import com.example.university.model.dto.StudentDTO;
import com.example.university.repository.StudentRepository;
import com.example.university.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<Student> getPageOfStudent(Pageable pageable, Specification specification) {
        return studentRepository.findAll(specification, pageable);
    }

    @Override
    public List<Student> getListOfStudent() {
        return studentRepository.findAll();
    }

    @Transactional
    @Override
    public void createStudent(StudentDTO studentDTO) {
        if(studentRepository.findStudentByAllParam(
                studentDTO.getName(),
                studentDTO.getLastname(),
                studentDTO.getPatronymic(),
                studentDTO.getUgid()
        ) == null){
            Student student = new Student(
                    null,
                    studentDTO.getName(),
                    studentDTO.getLastname(),
                    studentDTO.getPatronymic(),
                    studentDTO.getUgid()
            );
            studentRepository.save(student);
        }else {
            throw new RuntimeException("This entry already exists");
        }
    }

    @Transactional
    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Student student = studentRepository.getById(studentDTO.getId());
        if(student != null){
            student.setLastname(studentDTO.getLastname());
            student.setName(studentDTO.getName());
            student.setPatronymic(studentDTO.getPatronymic());
            student.setUgid(studentDTO.getUgid());
            studentRepository.save(student);
        }else {
            throw new RuntimeException("This entry is not");
        }
    }

    @Transactional
    @Override
    public void deleteStudent(long id) {
        studentRepository.delete(studentRepository.getById(id));
    }
}
