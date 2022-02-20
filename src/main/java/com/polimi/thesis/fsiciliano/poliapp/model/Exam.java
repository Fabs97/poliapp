package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_start", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "teaching_code", nullable = false)
    private String teachingCode;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "lecturer", nullable = false)
    private String lecturer;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Room room;
}
