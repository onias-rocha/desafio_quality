package com.digitalhouse.desafioquality.rest.impl;

import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.rest.ChallengeController;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;
import com.digitalhouse.desafioquality.service.ChallengeService;
import com.digitalhouse.desafioquality.service.RoomResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChallengeControllerImpl implements ChallengeController {

    ChallengeService service;

    public ChallengeControllerImpl(ChallengeService service) {
        this.service = service;
    }

    @GetMapping
    public String welcomeMessage(){
        return "Welcome to the properties API";
    }

    @PostMapping("/calculateSquareMeters")
    public Double calculateSquareMeters(@RequestBody PropertyRequestDTO dto){
        return service.calculateSquareMeters(dto);
    }

    @PostMapping("/calculatePropertyValue")
    public Double calculatePropertyValue(@RequestBody PropertyRequestDTO property) {
        return service.calculatePropertyValue(property);
    }

    @PostMapping("/calculateBiggestRoom")
    public Room calculateBiggestRoom(@RequestBody PropertyRequestDTO property) {
        return service.calculateBiggestRoom(property);
    }

    @PostMapping("/calculateAllRoomsSquareMeters")
    public List<RoomResponseDTO> calculateAllRoomsSquareMetersRestfully(@RequestBody PropertyRequestDTO property) {
        return service.calculateAllRoomsSquareMetersRestfully(property);
    }
}
