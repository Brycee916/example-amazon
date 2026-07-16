package org.amazon.example;

import org.springframework.stereotype.Service;

@Service //indicates that it contains the business logic of application, a BEAN
public class WelcomeService {

    public String getWelcomeMessage(){
        return "Welcome to the Spring Boot Rest API";
    }
}
