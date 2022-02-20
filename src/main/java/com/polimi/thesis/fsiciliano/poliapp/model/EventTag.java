package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event_tag")
public class EventTag{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value")
    private String value;

    public EventTag() {}
}
