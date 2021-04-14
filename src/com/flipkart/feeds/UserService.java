package com.flipkart.feeds;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userRegistry;

    UserService() {
        this.userRegistry = new HashMap<>();
    }

    public User getUser(String email) {
        if (this.userRegistry.containsKey(email)) {
            return this.userRegistry.get(email);
        }
        throw new RuntimeException("User doesn't exist");
    }

    public void registerUser(User user) {
        if (this.userRegistry.containsKey(user.getEmail())) {
            throw new RuntimeException("User already exist");
        }
        this.userRegistry.put(user.getEmail(), user);
    }
}
