package com.example.university.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AuditoryDTO {

    private Long id;
    @NotNull(message = "Place is mandatory")
    private String place;

}
