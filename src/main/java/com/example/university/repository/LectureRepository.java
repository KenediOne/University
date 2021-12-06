package com.example.university.repository;

import com.example.university.model.domain.Auditory;
import com.example.university.model.domain.Lecture;
import com.example.university.model.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends PagingAndSortingRepository<Lecture, Long>, JpaRepository<Lecture, Long>, JpaSpecificationExecutor<Lecture> {

    @Query("SELECT l FROM Lecture l WHERE " +
            "l.dayOfWeek = :dayOfWeek AND " +
            "l.name_lecture = :name_lecture AND " +
            "l.teacher = :teacher AND " +
            "l.ugid = :ugid AND " +
            "l.place = :place")
    Lecture findLectureByAllParam(
            @Param("dayOfWeek")String dayOfWeek,
            @Param("name_lecture")String name_lecture,
            @Param("teacher")Teacher teacher,
            @Param("ugid")long ugid,
            @Param("place")Auditory place
            );

}
