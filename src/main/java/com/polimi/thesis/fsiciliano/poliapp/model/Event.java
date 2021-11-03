package com.polimi.thesis.fsiciliano.poliapp.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;
import org.springframework.core.annotation.Order;
import org.springframework.data.web.JsonPath;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_start", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Column(name = "date_end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "notes", nullable = false)
    private String notes;

    @OrderBy("dateStart ASC")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Occupancy> occupancies;

    //    TODO: event organizer and tags
//    private String organizer;
//    private String[] tags;
    public Event() {
    }

    public Event(Date dateStart, Date dateEnd, String title, String notes, List<Occupancy> occupancies) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.occupancies = occupancies;
        this.title = title;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Occupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(List<Occupancy> occupancies) {
        this.occupancies = occupancies;
    }

}
