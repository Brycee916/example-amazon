package org.amazon.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {

    private final WelcomeService welcomeService;

    @Autowired //makes spring automatically search for the bean from the service layer. inject the WelcomeService dependency into this controller automatically
    public WelcomeController(WelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return welcomeService.getWelcomeMessage(); //automatically converted to json with @RestController
    }
    

}
