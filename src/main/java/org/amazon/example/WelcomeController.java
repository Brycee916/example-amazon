package org.amazon.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final WelcomeService welcomeService;

    //class note really needed
    @Autowired
    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    //welcome api
    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return welcomeService.getWelcomeMessage();
    }
}

