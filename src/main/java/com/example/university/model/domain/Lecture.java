package com.example.university.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name of lecture is mandatory")
    @Column( name = "name_lecture" )
    private String name_lecture;

    @NotBlank(message = "Day of week is mandatory")
    @Column( name = "day_of_week" )
    private String dayOfWeek;

    @NotNull(message = "Teacher is mandatory")
    @ManyToOne
    @JoinColumn( name = "teacher", nullable = false )
    private Teacher teacher;

    @NotNull(message = "UGID is mandatory")
    @Column( name = "ugid" )
    private long ugid;

    @NotNull(message = "Place is mandatory")
    @JoinColumn( name = "place" )
    @ManyToOne
    private Auditory place;

}
