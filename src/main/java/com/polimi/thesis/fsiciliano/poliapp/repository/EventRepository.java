package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    @Query(
            value = "select event from Event event " +
                    "where event.student.id = :studentId " +
                    "and event.id = :eventId"
    )
    Event findEventDetailByIdWhereStudentIdEquals(@Param("studentId") Long studentId, @Param("eventId") Long eventId);


    @Query(
            value = "select event from Event event " +
                    "where event.student.id = :studentId"
    )
    List<Event> findEventsByStudentId(@Param("studentId") Long studentId);

    @Query(
            value = "select event from Event event " +
                    "join Exam exam on exam.id = event.exam.id " +
                    "join Lecture lecture on lecture.id = event.lecture.id " +
                    "join Administrative administrative on administrative.id = event.administrative.id " +
                    "join News news on news.id = event.news.id " +
                    "join CustomEvent custom on custom.id = event.custom.id " +
                    "where event.id = :eventId"
    )
    Event findEventById(@Param("eventId") Long eventId);
}