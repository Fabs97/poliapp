package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.model.Building;
import com.polimi.thesis.fsiciliano.poliapp.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public Optional<Building> findById(Long buildingId) {
        return buildingRepository.findById(buildingId);
    }
}
