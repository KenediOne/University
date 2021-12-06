package com.example.university.service.impl;

import com.example.university.model.domain.Lecture;
import com.example.university.model.dto.LectureDTO;
import com.example.university.repository.AuditoryRepository;
import com.example.university.repository.LectureRepository;
import com.example.university.repository.TeacherRepository;
import com.example.university.service.LectureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final TeacherRepository teacherRepository;
    private final AuditoryRepository auditoryRepository;

    public LectureServiceImpl(LectureRepository lectureRepository, TeacherRepository teacherRepository, AuditoryRepository auditoryRepository) {
        this.lectureRepository = lectureRepository;
        this.teacherRepository = teacherRepository;
        this.auditoryRepository = auditoryRepository;
    }

    @Override
    public Page<Lecture> getPageOfLecture(Pageable pageable, Specification specification) {
        return lectureRepository.findAll(specification, pageable);
    }

    @Override
    public List<Lecture> getListOfLecture() {
        return lectureRepository.findAll();
    }

    @Transactional
    @Override
    public void createLecture(LectureDTO lectureDTO) {
        if(lectureRepository.findLectureByAllParam(
                lectureDTO.getName_lecture(),
                lectureDTO.getDayOfWeek(),
                teacherRepository.getById(lectureDTO.getTeacher()),
                lectureDTO.getUgid(),
                auditoryRepository.getById(lectureDTO.getPlace())
        ) == null){
            Lecture lecture = new Lecture(
                    null,
                    lectureDTO.getDayOfWeek(),
                    lectureDTO.getName_lecture(),
                    teacherRepository.getById(lectureDTO.getTeacher()),
                    lectureDTO.getUgid(),
                    auditoryRepository.getById(lectureDTO.getPlace())
            );
            lectureRepository.save(lecture);
        }else {
            throw new RuntimeException("This entry already exists");
        }
    }

    @Transactional
    @Override
    public void updateLecture(LectureDTO lectureDTO) {
        Lecture lecture = lectureRepository.getById(lectureDTO.getId());
        if(lecture != null){
            lecture.setName_lecture(lectureDTO.getName_lecture());
            lecture.setDayOfWeek(lectureDTO.getDayOfWeek());
            lecture.setPlace(auditoryRepository.getById(lectureDTO.getPlace()));
            lecture.setTeacher(teacherRepository.getById(lectureDTO.getTeacher()));
            lecture.setUgid(lectureDTO.getUgid());
            lectureRepository.save(lecture);
        }else {
            throw new RuntimeException("This entry is not");
        }
    }

    @Transactional
    @Override
    public void deleteLecture(long idLecture) {
        lectureRepository.delete(lectureRepository.getById(idLecture));
    }
}
