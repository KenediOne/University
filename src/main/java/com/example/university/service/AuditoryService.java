package com.example.university.service;

import com.example.university.model.domain.Auditory;
import com.example.university.model.dto.AuditoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuditoryService {

    Page<Auditory> getPageOfAuditory(Pageable pageable);

    List<Auditory> getListOfAuditory();

    void createAuditory(AuditoryDTO auditoryDTO);

    void updateAuditory(AuditoryDTO auditoryDTO);

    void deleteAuditory(long id);

}
