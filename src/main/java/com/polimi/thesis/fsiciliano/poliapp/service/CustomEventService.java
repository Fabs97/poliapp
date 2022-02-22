package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.bodies.POSTEventsCustomRequest;
import com.polimi.thesis.fsiciliano.poliapp.exception.BadRequestException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.*;
import com.polimi.thesis.fsiciliano.poliapp.model.Calendar;
import com.polimi.thesis.fsiciliano.poliapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactsGroupRepository contactsGroupRepository;

    @Transactional
    public CustomEvent postNewEvent(POSTEventsCustomRequest customEventRequest) throws BadRequestException {
        if(customEventRequest.getRoom() == null
            || customEventRequest.getStudentId() == null
            || customEventRequest.getDate_start() == null
            || customEventRequest.getDate_end() == null
            || customEventRequest.getTitle() == null)
                throw new BadRequestException("Error while parsing custom event request body");

        Room roomInRequest = customEventRequest.getRoom();

        Optional<Room> roomInDb = roomRepository.findById(roomInRequest.getId());
        if(roomInDb.isEmpty()) {
            roomInRequest.setId(null);
            customEventRequest.setRoom(roomRepository.save(roomInRequest));
        } else {
            customEventRequest.setRoom(roomInDb.get());
        }

//      Replace the student id in custom event request with the one obtained by saving it in the database
        Optional<Student> studentInDb = studentRepository.findById(customEventRequest.getStudentId());
        Student student = studentInDb.orElseGet(() -> studentRepository.save(new Student(customEventRequest.getStudentId())));

        CustomEvent customEventFromRequest = customEventRequest.getCustomEvent();

//      Create custom_student records for any shared members
//      Retrieve Contacts from database based on IDs
        Set<Contact> contacts = new HashSet<>(contactRepository.findAllById(customEventRequest.getShared_contacts()));
        Set<ContactsGroup> contactsGroups = new HashSet<>(contactsGroupRepository.findAllById(customEventRequest.getShared_groups()));

        customEventFromRequest.setSharedContacts(contacts.isEmpty() ? new HashSet<>() : contacts);
        customEventFromRequest.setSharedGroups(contactsGroups.isEmpty() ? new HashSet<>() : contactsGroups);

        CustomEvent newCustomEvent = customEventRepository.save(customEventFromRequest);

//      Create new event record
        Calendar customCalendar = calendarRepository.findCalendarByCalendarIdentifierContaining("custom");
        EventType eventType = eventTypeRepository.findEventTypeByEventTypeIdentifierContaining("custom");
        Event newEvent = eventService.save(customEventRequest.getEvent(customCalendar, eventType, newCustomEvent, student));

        return newCustomEvent;
    }

    public List<Event> getEventsByUserId(Long studentId, Integer limit) throws ResourceNotFoundException {
        List<Event> events = eventService.findAllByCustomNotNullAndStudentId(studentId, limit);
        if(events.isEmpty()) throw new ResourceNotFoundException("No custom events found for student :: " + studentId );
        return events;
    }
}
