package com.example.university.collection;

import com.example.university.model.domain.Lecture;
import com.example.university.model.dto.LectureDTO;
import com.example.university.pagination.PageBuilder;
import com.example.university.service.LectureService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LecturesControllers extends BaseController{

    private final LectureService lectureService;

    public LecturesControllers(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping(value = BaseController.LECTURES, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Lecture> getLecture(
            @RequestParam(value = "page", defaultValue = "0,10", required = false) String page,
            @RequestParam(value = "sort", defaultValue = "dayOfWeek:ASC", required = false) String sort,
            @SearchSpec Specification<Lecture> specs
    ){
        return lectureService.getPageOfLecture(PageBuilder.build(page, sort), Specification.where(specs));
    }

    @GetMapping(value = BaseController.LECTURES_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Lecture> getLectureAll(){
        return lectureService.getListOfLecture();
    }

    @ResponseBody
    @PostMapping(value = BaseController.LECTURES, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createLecture(
            @RequestBody LectureDTO lectureDTO
    ){
        lectureService.createLecture(lectureDTO);
    }

    @ResponseBody
    @PutMapping(value = BaseController.LECTURES, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLecture(
            @RequestBody LectureDTO lectureDTO
    ){
        lectureService.updateLecture(lectureDTO);
    }

    @DeleteMapping(value = BaseController.LECTURES, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteLecture(
            @RequestParam(value = "id")long id
    ){
        lectureService.deleteLecture(id);
    }

}
