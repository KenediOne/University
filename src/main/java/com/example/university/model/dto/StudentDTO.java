package com.example.university.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    @NotBlank(message = "Patronymic is mandatory")
    private String patronymic;

    @NotNull(message = "UGID is mandatory")
    private long ugid;
}
