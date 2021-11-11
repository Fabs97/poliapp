package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "floor", nullable = false)
    private String floor;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "room")
    private Collection<Occupancy> occupancy;

    public Room() {}

    public Room(String floor, String name, Building building) {
        this.floor = floor;
        this.name = name;
        this.building = building;
    }
}
