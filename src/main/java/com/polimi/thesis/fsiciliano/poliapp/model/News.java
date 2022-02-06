package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Room room;

    public News() {}
}
