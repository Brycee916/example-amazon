package org.amazon.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Map<Long, User> usersById = new HashMap<>();
    private final Map<String, User> usersByUsername = new HashMap<>();
    private final PasswordEncoder passwordEncoder;
    private long nextId = 1L;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        User admin = new User("admin", "admin123", "ADMIN");
        registerUser(admin);

        User regular = new User("user", "user123", "USER");
        registerUser(regular);
    }

    public User createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setId(nextId++);

        usersById.put(user.getId(), user);
        usersByUsername.put(user.getUsername(), user);
        return user;
    }

    public void registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (user.getPassword() != null && !user.getPassword().startsWith("$2a$")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        if (user.getId() == 0L) {
            user.setId(nextId++);
        }

        usersById.put(user.getId(), user);
        usersByUsername.put(user.getUsername(), user);
    }

    public User findByUsername(String username) {
        return usersByUsername.get(username);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(usersById.values());
    }

    public User getUserById(long id) {
        return usersById.get(id);
    }

    public User updateUser(long id, User user){
        return usersById.put(id, user);
    }
}
