package org.amazon.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    //display the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model){

        model.addAttribute("user", new User());
        return "register"; //routes it
    }

    //handle the logic
    @PostMapping("/register")
    
}
