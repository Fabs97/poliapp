package com.polimi.thesis.fsiciliano.poliapp.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polimi.thesis.fsiciliano.poliapp.dto.building.BuildingDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("floor")
    private String floor;

    @JsonProperty("building")
    private BuildingDTO building;
}
