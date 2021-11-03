package com.polimi.thesis.fsiciliano.poliapp.model;

import javax.persistence.*;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}