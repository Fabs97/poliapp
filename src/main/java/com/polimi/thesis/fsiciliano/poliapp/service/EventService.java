package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.dto.event.EventGetDTO;
import com.polimi.thesis.fsiciliano.poliapp.dto.event.EventMapper;
import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.repository.EventRepository;
import com.polimi.thesis.fsiciliano.poliapp.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private EventMapper eventMapper;


    public EventGetDTO findById(Long eventId) throws ResourceNotFoundException {
        Optional<Event> event = eventRepository.findById(eventId);
//        Building building = buildingService.findById(event.room);
        if(event.isPresent())
            return eventMapper.eventToGetDTO(event.get());
        else
            throw new ResourceNotFoundException("Event not found for this id :: " + eventId);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void delete(Long eventId) throws ResourceNotFoundException{
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
        {
            eventRepository.delete(event);
        }
    }

    public Event patch(Long eventId, Event patch) throws InternalServerErrorException, ResourceNotFoundException{
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
        return eventRepository.save((Event) U.patch(event, patch));
    }
}
