package org.amazon.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//class serves the login page
// Spring Security provides built-in support to handle login
@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }
}
