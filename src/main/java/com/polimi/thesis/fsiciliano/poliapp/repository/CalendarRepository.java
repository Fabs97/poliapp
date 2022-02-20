package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    Calendar findCalendarByIdentifierContaining(String identifier);
}