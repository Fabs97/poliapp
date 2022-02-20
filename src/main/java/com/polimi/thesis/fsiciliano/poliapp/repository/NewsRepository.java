package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.model.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(
            value = "select event from Event event " +
                    "join News news on event.news.id = news.id " +
                    "where event.student.id = :studentId " +
                    "order by news.dateStart asc"
    )
    List<Event> findNewsOrderByDateAscBy(@Param("studentId") Long studentId,
                                         Pageable pageable);
}