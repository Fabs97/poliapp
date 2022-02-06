package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.repository.EventRepository;
import com.polimi.thesis.fsiciliano.poliapp.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ExamService examService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private AdministrativeEventService administrativeEventService;

    @Autowired
    private CustomEventService customEventService;

    public List<Event> findEventsToday(Long studentId, Boolean news, Boolean upcoming, Boolean highlights) {
        List<Event> events = new ArrayList<Event>();
        if(news) events.addAll(newsService.findTodayNews(studentId));
//        if(upcoming) events.addAll(newsService.findTodayNews());
//        if(highlights) events.addAll(newsService.findTodayNews());
        return events;
    }

    public List<Event> findEventsByStudentId(Long studentId) throws ResourceNotFoundException {
        List<Event> events = eventRepository.findEventsByStudentId(studentId);
        if(events == null || events.isEmpty()) throw new ResourceNotFoundException("No events found for this user id :: " + studentId);
        return events;
    }

    public Event findEventById(Long eventId) throws ResourceNotFoundException {
        Event event = eventRepository.findEventById(eventId);
        if(event == null) throw new ResourceNotFoundException("No event found with id :: " + eventId);
        return event;
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
