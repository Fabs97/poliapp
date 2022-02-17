package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.Administrative;
import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdministrativeRepository extends JpaRepository<Administrative, Long> {

    @Query(
            value = "select event from Event event " +
                    "join Administrative administrative on event.administrative.id = administrative.id " +
                    "where event.student.id = :studentId " +
                    "order by administrative.dateStart asc"
    )
    List<Event> findHighlights(@Param("studentId") Long studentId,
                                    Pageable pageable);
}