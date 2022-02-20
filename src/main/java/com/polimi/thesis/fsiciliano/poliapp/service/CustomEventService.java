package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.bodies.POSTEventsCustomRequest;
import com.polimi.thesis.fsiciliano.poliapp.model.*;
import com.polimi.thesis.fsiciliano.poliapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomEventService {
    @Autowired
    private CustomEventRepository customEventRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public CustomEvent postNewEvent(POSTEventsCustomRequest customEventRequest) {
        Room roomInRequest = customEventRequest.getRoom();

        Optional<Room> roomInDb = roomRepository.findById(roomInRequest.getId());
        if(!roomInDb.isPresent()) {
            roomInRequest.setId(null);
            customEventRequest.setRoom(roomRepository.save(roomInRequest));
        } else {
            customEventRequest.setRoom(roomInDb.get());
        }

//      Replace the student id in custom event request with the one obtained by saving it in the database
        Optional<Student> studentInDb = studentRepository.findById(customEventRequest.getStudentId());
        Student student = !studentInDb.isPresent()
                ? studentRepository.save(new Student(customEventRequest.getStudentId()))
                : studentInDb.get();

        CustomEvent newCustomEvent = customEventRepository.save(customEventRequest.getCustomEvent());

//      Create new event record
        Calendar customCalendar = calendarRepository.findCalendarByIdentifierContaining("custom");
        EventType eventType = eventTypeRepository.findEventTypeByIdentifierContaining("custom");
        Event newEvent = eventService.save(customEventRequest.getEvent(customCalendar, eventType, newCustomEvent, student));
//      Create custom_student records for any shared members
//      Create shared_contacts and shared_groups joins?
        return newCustomEvent;
    }
}
