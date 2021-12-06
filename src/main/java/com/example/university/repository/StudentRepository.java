package com.example.university.repository;

import com.example.university.model.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    @Query("SELECT s FROM Student s WHERE " +
            "s.name = :name AND " +
            "s.lastname = :lastname AND " +
            "s.patronymic = :patronymic AND " +
            "s.ugid = :ugid")
    Student findStudentByAllParam(
            @Param("name")String name,
            @Param("lastname")String lastname,
            @Param("patronymic")String patronymic,
            @Param("ugid")long ugid
    );

}
