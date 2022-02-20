package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.repository.AdministrativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrativeEventService {
    @Autowired
    private AdministrativeRepository administrativeRepository;

    public List<Event> findHighlights(Long studentId, Integer limit) {
        return administrativeRepository.findHighlights(studentId, PageRequest.of(0, limit));
    }
}
