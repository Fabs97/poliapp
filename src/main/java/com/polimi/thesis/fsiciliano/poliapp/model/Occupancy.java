package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "occupancy")
public class Occupancy {
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
    @Column(name = "whole_room", nullable = false)
    private Boolean wholeRoom;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

//    TODO: occupancy => table

    public Occupancy () {}

    public Occupancy(Date dateStart, Date dateEnd, Boolean wholeRoom, Room room) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.wholeRoom = wholeRoom;
        this.room = room;
    }
}
