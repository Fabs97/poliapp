package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event_type")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "event_type_value", nullable = false)
    private String eventTypeValue;

    @Column(name = "event_type_identifier", nullable = false)
    private String eventTypeIdentifier;
}
