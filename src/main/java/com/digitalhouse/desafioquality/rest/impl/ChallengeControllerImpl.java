package com.digitalhouse.desafioquality.rest.impl;

import com.digitalhouse.desafioquality.rest.ChallengeController;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;
import com.digitalhouse.desafioquality.service.ChallengeService;
import org.springframework.web.bind.annotation.*;

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
        return service.calculateSquareMeters(dto.turnIntoProperty());
    }
}
