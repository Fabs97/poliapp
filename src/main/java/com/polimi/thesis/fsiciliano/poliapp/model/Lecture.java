package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "teaching_code", nullable = false)
    private String teaching_code;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "lecturer", nullable = false)
    private String lecturer;

    @Column(name = "remote_link", nullable = false)
    private String remote_link;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Room room;

    public Lecture() {}
}
