package com.example.university.collection;

import com.example.university.model.domain.Lecture;
import com.example.university.model.domain.Student;
import com.example.university.model.domain.Teacher;
import com.example.university.model.dto.TeacherDTO;
import com.example.university.pagination.PageBuilder;
import com.example.university.service.TeacherService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherControllers extends BaseController{

    private final TeacherService teacherService;

    public TeacherControllers(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = BaseController.TEACHERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Teacher> getTeacher(
            @RequestParam(value = "page", defaultValue = "0,10", required = false) String page,
            @RequestParam(value = "sort", defaultValue = "name:ASC", required = false) String sort
    ){
        return teacherService.getPageOfTeacher(PageBuilder.build(page, sort));
    }

    @GetMapping(value = BaseController.TEACHERS_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getTeacherAll(){
        return teacherService.getListOfTeacher();
    }

    @ResponseBody
    @PostMapping(value = BaseController.TEACHERS, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTeacher(
            @RequestBody TeacherDTO teacherDTO
    ){
        teacherService.createTeacher(teacherDTO);
    }

    @ResponseBody
    @PutMapping(value = BaseController.TEACHERS, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTeacher(
            @RequestBody TeacherDTO teacherDTO
    ){
        teacherService.updateTeacher(teacherDTO);
    }

    @DeleteMapping(value = BaseController.TEACHERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTeacher(
            @RequestParam(value = "id")long id
    ){
        teacherService.deleteTeacher(id);
    }
}
