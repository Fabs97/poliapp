package com.polimi.thesis.fsiciliano.poliapp.service;

import com.polimi.thesis.fsiciliano.poliapp.model.Room;
import com.polimi.thesis.fsiciliano.poliapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Optional<Room> findById(Long roomId){
        return roomRepository.findById(roomId);
    }
}
