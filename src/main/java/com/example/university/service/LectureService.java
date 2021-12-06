package com.example.university.service;

import com.example.university.model.domain.Lecture;
import com.example.university.model.dto.LectureDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface LectureService {

    Page<Lecture> getPageOfLecture(Pageable pageable, Specification specification);

    List<Lecture> getListOfLecture();

    void createLecture(LectureDTO lectureDTO);

    void updateLecture(LectureDTO lectureDTO);

    void deleteLecture(long idLecture);

}
