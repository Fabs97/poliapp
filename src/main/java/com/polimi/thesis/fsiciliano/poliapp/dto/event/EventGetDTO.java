package com.polimi.thesis.fsiciliano.poliapp.dto.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polimi.thesis.fsiciliano.poliapp.dto.room.RoomDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventGetDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("dateStart")
    private Date dateStart;

    @JsonProperty("dateEnd")
    private Date dateEnd;

    @JsonProperty("title")
    private String title;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("description")
    private String description;

    @JsonProperty("room")
    private RoomDTO room;
}
