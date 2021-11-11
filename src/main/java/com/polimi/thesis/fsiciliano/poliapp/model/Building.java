package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Table(name = "building")
@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "latitude", nullable = false)
    private long latitude;
    @Column(name = "longitude", nullable = false)
    private long longitude;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "campus", nullable = false)
    private String campus;
    @Column(name = "name", nullable = false)
    private String name;

    @OrderBy("name ASC")
    @OneToMany(mappedBy = "building", cascade = CascadeType.REMOVE)
    private List<Room> rooms;

    public Building() {}

    public Building(long latitude, long longitude, String address, String campus, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.campus = campus;
        this.name = name;
    }
}