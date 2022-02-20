package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "custom_event")
public class CustomEvent {

    @GenericGenerator(
            name = "custom_event_id_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "CUSTOM_EVENT_GENERATOR"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "custom_event_id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "location", nullable = false)
    private String location;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Room room;

    @Column(name = "date_start", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany
    private Set<Contact> sharedContacts;

    @ManyToMany
    private Set<ContactsGroup> sharedGroups;

    public CustomEvent() {}

    public CustomEvent(Long id) {
        this.id = id;
    }

}
