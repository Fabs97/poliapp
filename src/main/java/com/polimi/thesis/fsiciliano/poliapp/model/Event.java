package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private EventType eventType;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Student student;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Calendar calendar;

    @Column(name = "date_start", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "alert_value")
    private Short alert_value;

    @Column(name = "alert_unit")
    private AlertUnit alert_unit;

    @Column(name = "notes", nullable = false)
    private String notes;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Exam exam;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Lecture lecture;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Administrative administrative;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private News news;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private CustomEvent custom;

    public Event() {
    }

}
