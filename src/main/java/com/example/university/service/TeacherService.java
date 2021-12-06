package com.example.university.service;

import com.example.university.model.domain.Teacher;
import com.example.university.model.dto.TeacherDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {

    Page<Teacher> getPageOfTeacher(Pageable pageable);

    List<Teacher> getListOfTeacher();

    void createTeacher(TeacherDTO teacher);

    void updateTeacher(TeacherDTO teacher);

    void deleteTeacher(long id);

}
