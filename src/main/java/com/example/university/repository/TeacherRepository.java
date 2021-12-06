package com.example.university.repository;

import com.example.university.model.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long>, JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE " +
            "t.name = :name AND " +
            "t.lastname = :lastname AND " +
            "t.patronymic = :patronymic")
    Teacher findTeacherByAllParam(
            @Param("name")String name,
            @Param("lastname")String lastname,
            @Param("patronymic")String patronymic
    );

}
