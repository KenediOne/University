package com.example.university.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class LectureDTO {

    private Long id;

    @NotBlank(message = "Name of lecture is mandatory")
    private String name_lecture;

    @NotBlank(message = "Day of week is mandatory")
    private String dayOfWeek;

    @NotNull(message = "Teacher is mandatory")
    private long teacher;

    @NotNull(message = "UGID is mandatory")
    private long ugid;

    @NotNull(message = "Place is mandatory")
    private long place;

}
