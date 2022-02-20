package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

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

    @Column(name = "alert_value")
    private Short alertValue;

    @Column(name = "alert_unit")
    private AlertUnit alertUnit;

    @Column(name = "notes")
    private String notes;

    @Column(name = "favourite")
    private Boolean favourite = false;

    @Column(name = "show_agenda")
    private Boolean showAgenda = false;

    @Column(name = "badgeNumber")
    private String badgeNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    private Exam exam;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    private Lecture lecture;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    private Administrative administrative;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    private News news;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    private CustomEvent custom;

    public Event() {
    }

}
