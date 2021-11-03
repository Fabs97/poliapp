package com.polimi.thesis.fsiciliano.poliapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

//    TODO: occupancy => table

    public Occupancy () {}

    public Occupancy(Date dateStart, Date dateEnd, Boolean wholeRoom) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.wholeRoom = wholeRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Boolean getWholeRoom() {
        return wholeRoom;
    }

    public void setWholeRoom(Boolean wholeRoom) {
        this.wholeRoom = wholeRoom;
    }

    public Room getRoom() {
        return room;
    }

}
