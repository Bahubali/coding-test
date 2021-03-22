package com.splitwise;

import com.google.inject.Singleton;
import com.google.inject.internal.cglib.core.$ClassEmitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class UserRegistry {

    Map<String, User> allUsers;
    public UserRegistry() {
        this.allUsers = new HashMap<String, User>();
    }

    public Map<String, User> getAllUsers() {
        return this.allUsers;
    }

    public void add(User user) throws Exception {
        if (this.allUsers.containsKey(user.getEmailAddress()))
            throw new Exception("User already exist with email "+user.getEmailAddress());
        this.allUsers.put(user.getEmailAddress(), user);
    }

    public User get(String email) {
        return this.allUsers.get(email);
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for (Map.Entry<String, User> entry : allUsers.entrySet()) {
            users.add(entry.getValue());
        }
        return users;
    }
}
