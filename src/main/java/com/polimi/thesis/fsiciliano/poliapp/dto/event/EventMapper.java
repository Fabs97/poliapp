package com.polimi.thesis.fsiciliano.poliapp.dto.event;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;

public interface EventMapper {
    EventGetDTO eventToGetDTO(Event source);
}
