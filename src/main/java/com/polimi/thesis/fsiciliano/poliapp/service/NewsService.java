package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<Event> findTodayNews(Long studentId, Integer limit) {
        return newsRepository.findNewsOrderByDateAscBy(studentId, PageRequest.of(0, limit));
    }
}
