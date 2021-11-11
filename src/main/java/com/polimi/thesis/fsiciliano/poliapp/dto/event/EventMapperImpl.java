package com.polimi.thesis.fsiciliano.poliapp.dto.event;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;

public class EventMapperImpl implements EventMapper {
    public EventGetDTO eventToGetDTO(Event source) {
        EventGetDTO dto = new EventGetDTO();
        dto.setId(source.getId());
        dto.setDateStart(source.getDateStart());
        dto.setDateEnd(source.getDateEnd());
        dto.setTitle(source.getTitle());
        dto.setNotes(source.getNotes());
//        dto.setRoom();
        return dto;
    }
}
