package com.example.university.collection;

import com.example.university.model.domain.Auditory;
import com.example.university.model.dto.AuditoryDTO;
import com.example.university.model.dto.TeacherDTO;
import com.example.university.pagination.PageBuilder;
import com.example.university.service.AuditoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditoryControllers extends BaseController{

    private final AuditoryService auditoryService;

    public AuditoryControllers(AuditoryService auditoryService) {
        this.auditoryService = auditoryService;
    }


    @GetMapping(value = BaseController.AUDITORY, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Auditory> getAuditory(
            @RequestParam(value = "page", defaultValue = "0,10", required = false) String page,
            @RequestParam(value = "sort", defaultValue = "place:ASC", required = false) String sort
    ){
        return auditoryService.getPageOfAuditory(PageBuilder.build(page, sort));
    }

    @GetMapping(value = BaseController.AUDITORY_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Auditory> getAuditoryAll(){
        return auditoryService.getListOfAuditory();
    }

    @ResponseBody
    @PostMapping(value = BaseController.AUDITORY, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAuditory(
            @RequestBody AuditoryDTO auditoryDTO
    ){
        auditoryService.createAuditory(auditoryDTO);
    }

    @ResponseBody
    @PutMapping(value = BaseController.AUDITORY, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAuditory(
            @RequestBody AuditoryDTO auditoryDTO
    ){
        auditoryService.updateAuditory(auditoryDTO);
    }

    @DeleteMapping(value = BaseController.AUDITORY, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAuditory(
            @RequestParam(value = "id")long id
    ){
        auditoryService.deleteAuditory(id);
    }

}
