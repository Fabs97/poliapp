package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @GenericGenerator(
            name = "student_id_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "STUDENT_GENERATOR"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "student_id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    public Student () {}

    public Student(Long id) {
        this.id = id;
    }
}
