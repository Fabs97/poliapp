package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event_tag_news")
public class EventTagNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private EventTag eventTag;

//    @OneToOne(optional = false, fetch = FetchType.LAZY)
//    private News news;

}
