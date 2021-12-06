package com.example.university.repository;

import com.example.university.model.domain.Auditory;
import com.example.university.model.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoryRepository extends PagingAndSortingRepository<Auditory, Long>, JpaRepository<Auditory, Long> {

    @Query("SELECT a FROM Auditory a WHERE a.place = :place")
    Auditory findAuditoryByAllParam(
            @Param("place")String place
    );

}
