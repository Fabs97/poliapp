package com.polimi.thesis.fsiciliano.poliapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.Building;
import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.repository.EventRepository;
import com.polimi.thesis.fsiciliano.poliapp.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BuildingService buildingService;


    public Optional<Event> findById(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
//        Building building = buildingService.findById(event.room);
        return event;
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void delete(Event event){
        eventRepository.delete(event);
    }

    public Event patch(Long eventId, Event patch) throws InternalServerErrorException, ResourceNotFoundException{
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
        return eventRepository.save((Event) U.patch(event, patch));
    }
}
