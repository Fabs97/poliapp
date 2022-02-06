package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "campus", nullable = false)
    private String campus;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "floor", nullable = false)
    private String floor;

    @Column(name = "building", nullable = false)
    private String building;

    public Room() {}

    public Room( String name, String campus, String address, String floor, String building) {
        this.name = name;
        this.campus = campus;
        this.address = address;
        this.floor = floor;
        this.building = building;
    }
}
