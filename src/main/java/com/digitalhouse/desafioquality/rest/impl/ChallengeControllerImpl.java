package com.digitalhouse.desafioquality.rest.impl;

import com.digitalhouse.desafioquality.rest.ChallengeController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ChallengeControllerImpl implements ChallengeController {

    @GetMapping
    public String welcomeMessage(){
        return "Welcome to the properties API";
    }
}
