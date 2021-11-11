package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.exception.ForbiddenException;
import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.Event;
import com.polimi.thesis.fsiciliano.poliapp.model.Occupancy;
import com.polimi.thesis.fsiciliano.poliapp.repository.EventRepository;
import com.polimi.thesis.fsiciliano.poliapp.repository.OccupancyRepository;
import com.polimi.thesis.fsiciliano.poliapp.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupancyService {

    @Autowired
    private EventService eventService;

    @Autowired
    private OccupancyRepository occupancyRepository;

    @Autowired
    private EventRepository eventRepository;

    public Optional<Occupancy> findById(Long occupancyId) {
        return occupancyRepository.findById(occupancyId);
    }

    public List<Occupancy> findByEventId(Long eventId)
            throws ResourceNotFoundException {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
        {
            return event.getOccupancies();
        }
    }

    public List<Occupancy> saveOccupancyToEvent(Long eventId, Occupancy occupancy)
            throws ResourceNotFoundException, ForbiddenException {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
        {
            if (event.getOccupancies().add(occupancy)) {
                occupancyRepository.save(occupancy);
                eventService.save(event);
                return event.getOccupancies();
            }
            throw new ForbiddenException("Could not add occupancy to event with id :: " + eventId);
        }
    }

    public Occupancy patch(Long occupancyId, Occupancy patch) throws ForbiddenException, InternalServerErrorException, ResourceNotFoundException {
        Occupancy occupancy = occupancyRepository.findById(occupancyId)
                .orElseThrow(() -> new ResourceNotFoundException("Occupancy not found for this id :: " + occupancyId));
        {
            if(canSaveOccupancy(patch))
                return occupancyRepository.save((Occupancy) U.patch(occupancy, patch));

            throw new ForbiddenException("Occupancy can not be saved due to time scheduling issues");
        }
    }

    private boolean canSaveOccupancy(Occupancy occupancy) {
//        TODO: discuss business logic with ASICT
        List<Occupancy> list = occupancyRepository.getOccupanciesInDateRangeOf(
                U.formatDateToORCL(occupancy.getDateStart()),
                U.formatDateToORCL(occupancy.getDateEnd()),
                occupancy.getRoom().getId());
        return list.isEmpty();
    }
}
