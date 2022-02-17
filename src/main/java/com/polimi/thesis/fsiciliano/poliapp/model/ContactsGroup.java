package com.polimi.thesis.fsiciliano.poliapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "contacts_group")
public class ContactsGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Student student;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany
    private Set<Contact> contacts;

    @ManyToMany
    private Set<CustomEvent> events;
}
