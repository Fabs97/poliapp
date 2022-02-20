package com.polimi.thesis.fsiciliano.poliapp.controller;

import com.polimi.thesis.fsiciliano.poliapp.model.Room;
import com.polimi.thesis.fsiciliano.poliapp.service.RoomService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Hidden
@RestController
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    @ResponseBody
    public Optional<Room> getRoom(@RequestParam(name = "roomId") Long roomId) {
        return roomService.findById(roomId);
    }

    @PostMapping("/rooms")
    public Room postRoom (@Valid @RequestBody Room room) {
        return roomService.save(room);
    }
}
