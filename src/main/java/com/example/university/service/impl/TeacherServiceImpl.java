package com.example.university.service.impl;

import com.example.university.model.domain.Teacher;
import com.example.university.model.dto.TeacherDTO;
import com.example.university.repository.TeacherRepository;
import com.example.university.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Page<Teacher> getPageOfTeacher(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public List<Teacher> getListOfTeacher(){
        return teacherRepository.findAll();
    }

    @Transactional
    @Override
    public void createTeacher(TeacherDTO teacherDTO) {
        if(teacherRepository.findTeacherByAllParam(
                teacherDTO.getName(),
                teacherDTO.getLastname(),
                teacherDTO.getPatronymic()
        ) == null){
            Teacher teacher = new Teacher(
                    null,
                    teacherDTO.getName(),
                    teacherDTO.getLastname(),
                    teacherDTO.getPatronymic()
            );
            teacherRepository.save(teacher);
        }else {
            throw new RuntimeException("This entry already exists");
        }
    }

    @Transactional
    @Override
    public void updateTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.getById(teacherDTO.getId());
        if(teacher != null) {
            teacher.setName(teacherDTO.getName());
            teacher.setLastname(teacherDTO.getLastname());
            teacher.setPatronymic(teacherDTO.getPatronymic());
            teacherRepository.save(teacher);
        }
        else {
            throw new RuntimeException("This entry is not");
        }
    }

    @Transactional
    @Override
    public void deleteTeacher(long id) {
        teacherRepository.delete(teacherRepository.getById(id));
    }
}
