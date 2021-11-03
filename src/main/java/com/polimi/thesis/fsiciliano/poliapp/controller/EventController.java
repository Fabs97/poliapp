package com.polimi.thesis.fsiciliano.poliapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.polimi.thesis.fsiciliano.poliapp.exception.BadRequestException;
import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Event API Controller. APIs to do
 * [ ] GET      /events/deadlines
 * [ ] GET      /events/custom
 * [X] POST     /events/custom
 * [X] PATCH    /events/custom
 * [ ] GET      /events/social
 * [ ] GET      /events/today
 * [X] GET      /events
 * [X] DELETE   /events
 * [ ] GET      /events/calendar
 * [ ] POST     /events/calendar
 * [ ] DELETE   /events/calendar
 * [ ] PATCH    /events/calendar
 * [ ] GET      /events/calendar/{userId}
 * [ ] GET      /applications
 * [ ] POST     /applications
 * */
@RestController
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public Optional<Event> getEvent(@RequestParam(name = "id") Long eventId) {
        return eventService.findById(eventId);
    }

    @PostMapping("/events/custom")
    public Event createCustomEvent(@Valid @RequestBody Event event) {
        return eventService.save(event);
    }

    @DeleteMapping("/events")
    @ResponseBody
    public ResponseEntity deleteEvent(@RequestParam(name = "id") Long eventId)
            throws ResourceNotFoundException{
        Event event = eventService.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
        {
            eventService.delete(event);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("/events/custom")
    public Event patchCustomEvent(@RequestParam(name = "eventId") Long eventId, @RequestBody Event patch) throws
            InternalServerErrorException, ResourceNotFoundException {
        return eventService.patch(eventId, patch);
    }
}
