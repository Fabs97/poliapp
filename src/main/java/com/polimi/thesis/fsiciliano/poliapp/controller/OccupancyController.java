package com.polimi.thesis.fsiciliano.poliapp.controller;

import com.polimi.thesis.fsiciliano.poliapp.exception.ForbiddenException;
import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;
import com.polimi.thesis.fsiciliano.poliapp.exception.ResourceNotFoundException;
import com.polimi.thesis.fsiciliano.poliapp.model.Occupancy;
import com.polimi.thesis.fsiciliano.poliapp.service.OccupancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class OccupancyController {
    @Autowired
    private OccupancyService occupancyService;

    @GetMapping("/occupancies")
    @ResponseBody
    public List<Occupancy> getOccupancy(@RequestParam(name = "eventId") Long eventId) throws ResourceNotFoundException{
        return occupancyService.findByEventId(eventId);
    }

    @PostMapping("/occupancies")
    public List<Occupancy> postOccupancy (
            @RequestParam(name = "eventId") Long eventId,
            @Valid @RequestBody Occupancy occupancy)
        throws ResourceNotFoundException, ForbiddenException {
        return occupancyService.saveOccupancyToEvent(eventId, occupancy);
    }

    @PatchMapping("/occupancies")
    public Occupancy patchOccupancy(
            @RequestParam(name = "occupancyId") Long occupancyId,
            @Valid @RequestBody Occupancy patch)
    throws ForbiddenException, InternalServerErrorException, ResourceNotFoundException {
        return occupancyService.patch(occupancyId, patch);
    }
}
