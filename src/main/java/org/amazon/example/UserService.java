package org.amazon.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    //create in memory bc no db yet of the users
    private final Map<String, User> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user){
        //encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //store the user in the map
        users.put(user.getUsername(), user);
    }
    public User findByUsername(String username){
        return users.get(username);
    }

    public Map<String, User> getAllUsers(){
        return users;
    }
}
