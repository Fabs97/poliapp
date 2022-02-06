package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "administrative")
public class Administrative{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "academic_year")
    private String academicYear;

    @Column(name = "external_link")
    private String externalLink;

    public Administrative() {}
}
