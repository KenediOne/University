package com.example.university.collection;

import com.example.university.model.domain.Lecture;
import com.example.university.model.domain.Student;
import com.example.university.model.dto.StudentDTO;
import com.example.university.pagination.PageBuilder;
import com.example.university.service.StudentService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentControllers extends BaseController{

    private final StudentService studentService;

    public StudentControllers(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = BaseController.STUDENTS, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Student> getStudent(
            @RequestParam(value = "page", defaultValue = "0,10", required = false) String page,
            @RequestParam(value = "sort", defaultValue = "ugid:ASC", required = false) String sort,
            @SearchSpec Specification<Student> specs
    ){
        return studentService.getPageOfStudent(PageBuilder.build(page, sort), Specification.where(specs));
    }

    @GetMapping(value = BaseController.STUDENTS_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudentAll(){
        return studentService.getListOfStudent();
    }

    @ResponseBody
    @PostMapping(value = BaseController.STUDENTS, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createStudent(
            @RequestBody StudentDTO studentDTO
    ){
        studentService.createStudent(studentDTO);
    }

    @ResponseBody
    @PutMapping(value = BaseController.STUDENTS, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(
            @RequestBody StudentDTO studentDTO
    ){
        studentService.updateStudent(studentDTO);
    }

    @DeleteMapping(value = BaseController.STUDENTS, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(
            @RequestParam(value = "id")long id
    ){
        studentService.deleteStudent(id);
    }

}
