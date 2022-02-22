package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    Event findEventByIdAndStudentId(Long studentId, Long eventId);

    List<Event> findAllByStudentId(@Param("studentId") Long studentId,
                                   Pageable pageable);

    Event findEventById(Long eventId);

    List<Event> findAllByCustomNotNullAndStudentId(Long studentId, Pageable pageable);


}