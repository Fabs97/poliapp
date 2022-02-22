package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event")
public class Event {
    @GenericGenerator(
            name = "event_id_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "EVENT_GENERATOR"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "event_id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private EventType eventType;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Student student;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
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

    @Column(name = "badge_number")
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

}
