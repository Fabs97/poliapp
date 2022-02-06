package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    @MapsId
    private EventTag eventTag;

//    @OneToOne(optional = false, fetch = FetchType.LAZY)
//    @MapsId
//    private News news;

    public EventTagNews() {}
}
