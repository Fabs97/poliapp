package com.polimi.thesis.fsiciliano.poliapp.bodies;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GETEventsTodayResponse {
    private List<Event> upcoming;
    private List<Event> highlights;
    private List<Event> news;
}
