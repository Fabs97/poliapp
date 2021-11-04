package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
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
    @Column(name = "notes", nullable = false)
    private String notes;

    @OrderBy("dateStart ASC")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Occupancy> occupancies;

    //    TODO: event organizer and tags
//    private String organizer;
//    private String[] tags;
    public Event() {
    }

    public Event(Date dateStart, Date dateEnd, String title, String notes, List<Occupancy> occupancies) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.occupancies = occupancies;
        this.title = title;
        this.notes = notes;
    }

}
