package com.polimi.thesis.fsiciliano.poliapp.controller;

import com.polimi.thesis.fsiciliano.poliapp.exception.BadRequestException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Event API Controller. APIs to do
 * [ ] GET      /events/deadlines
 * [ ] GET      /events/custom
 * [ ] POST     /events/custom
 * [ ] PATCH    /events/custom
 * [ ] GET      /events/social
 * [ ] GET      /events/today
 * [X] GET      /events
 * [X] GET      /events/{eventId}
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

    @GetMapping("/events/today")
    public List<Event> getEventsToday(
            @RequestParam(defaultValue = "true", required = false) Boolean news,
            @RequestParam(defaultValue = "true", required = false) Boolean upcoming,
            @RequestParam(defaultValue = "true", required = false) Boolean highlights,
            @RequestParam Long studentId
            ) throws BadRequestException {
        return eventService.findEventsToday(studentId, news, upcoming, highlights);
    }

    /**
     * @param userId
     * @return a List of Events that can be seen by the requested user
     * @throws ResourceNotFoundException
     */
    @GetMapping("/events")
    public List<Event> getEvent(@RequestParam Long userId) throws ResourceNotFoundException {
        return eventService.findEventsByStudentId(userId);
    }

    /**
     * @param eventId
     * @return the Event details with according to the given eventId
     * @throws ResourceNotFoundException
     */
    @GetMapping("/events/{eventId}")
    public Event getEventById(@PathVariable Long eventId) throws ResourceNotFoundException {
        return eventService.findEventById(eventId);
    }

    /**
     * @param eventId
     * @return 204 NoContent if the resource has been successfully deleted
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/events")
    public ResponseEntity deleteEvent(@RequestParam Long eventId) throws ResourceNotFoundException {
        eventService.delete(eventId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
