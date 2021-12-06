package com.example.university.service.impl;

import com.example.university.model.domain.Auditory;
import com.example.university.model.domain.Teacher;
import com.example.university.model.dto.AuditoryDTO;
import com.example.university.model.dto.TeacherDTO;
import com.example.university.repository.AuditoryRepository;
import com.example.university.service.AuditoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditoryServiceImpl implements AuditoryService {

    private final AuditoryRepository auditoryRepository;

    public AuditoryServiceImpl(AuditoryRepository auditoryRepository) {
        this.auditoryRepository = auditoryRepository;
    }

    @Override
    public Page<Auditory> getPageOfAuditory(Pageable pageable) {
        return auditoryRepository.findAll(pageable);
    }

    @Override
    public List<Auditory> getListOfAuditory() {
        return auditoryRepository.findAll();
    }

    @Transactional
    @Override
    public void createAuditory(AuditoryDTO auditoryDTO) {
        if(auditoryRepository.findAuditoryByAllParam(
                auditoryDTO.getPlace()
        ) == null){
            Auditory auditory = new Auditory(
                    null,
                    auditoryDTO.getPlace()
            );
            auditoryRepository.save(auditory);
        }else {
            throw new RuntimeException("This entry already exists");
        }
    }

    @Transactional
    @Override
    public void updateAuditory(AuditoryDTO auditoryDTO) {
        Auditory auditory = auditoryRepository.getById(auditoryDTO.getId());
        if(auditory != null){
            auditory.setPlace(auditoryDTO.getPlace());
            auditoryRepository.save(auditory);
        }else {
            throw new RuntimeException("This entry is not");
        }
    }

    @Transactional
    @Override
    public void deleteAuditory(long id) {
        auditoryRepository.delete(auditoryRepository.getById(id));
    }

}
