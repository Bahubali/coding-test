package com.splitwise;

import com.google.inject.Singleton;

import java.util.HashMap;
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

    public void addUser(User user) throws Exception {
        if (this.allUsers.containsKey(user.getEmailAddress()))
            throw new Exception("User already exist with email "+user.getEmailAddress());
        this.allUsers.put(user.getEmailAddress(), user);
    }
}
