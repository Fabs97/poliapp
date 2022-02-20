package com.polimi.thesis.fsiciliano.poliapp.bodies;

import com.polimi.thesis.fsiciliano.poliapp.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class POSTEventsCustomRequest {

    private Date date_start;

    private Date date_end;

    private String title;

    private String location;

    private AlertUnit alert_unit;

    private Short alert_value;

    private String notes;

    private Boolean favourite;

    private Boolean show_agenda;
//
//    private String badge_number;

    private Room room;

    private Long studentId;

    private List<Long> shared_contacts;

    private List<Long> shared_groups;

    public CustomEvent getCustomEvent() {
        CustomEvent event = new CustomEvent();

        event.setRoom(this.room);
        event.setDateStart(this.date_start);
        event.setDateEnd(this.date_end);
        event.setTitle(this.title);
        event.setLocation(this.location);

        return event;
    }

    public Event getEvent(Calendar calendar, EventType eventType, CustomEvent customEvent, Student student) {
        Event event = new Event();
        event.setStudent(student);

        event.setCustom(customEvent != null ? customEvent : this.getCustomEvent());
        event.setCalendar(calendar);
        event.setEventType(eventType);

        event.setAdministrative(null);
        event.setNews(null);
        event.setLecture(null);
        event.setExam(null);

        event.setAlertUnit(this.alert_unit);
        event.setAlertValue(this.alert_value);
        event.setNotes(this.notes);
        event.setFavourite(this.favourite);
        event.setShowAgenda(this.show_agenda);

        return event;
    }
}
