package com.example.university.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

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

}
