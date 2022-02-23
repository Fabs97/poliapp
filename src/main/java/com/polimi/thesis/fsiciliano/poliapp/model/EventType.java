package com.polimi.thesis.fsiciliano.poliapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
