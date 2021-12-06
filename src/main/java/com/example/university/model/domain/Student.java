package com.example.university.model.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column( name = "name" )
    private String name;

    @NotBlank(message = "Lastname is mandatory")
    @Column( name = "lastname")
    private String lastname;

    @NotBlank(message = "Patronymic is mandatory")
    @Column( name = "patronymic")
    private String patronymic;

    @NotNull(message = "UGID is mandatory")
    @Column( name = "ugid" )
    private long ugid;
}
