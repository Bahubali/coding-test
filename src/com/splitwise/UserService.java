package com.splitwise;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final UserRegistry userRegistry;

    UserService() {
        this.userRegistry = new UserRegistry();
    }
    public User getUser(String email) {
        User user = userRegistry.get(email);
        if (user == null) {
            throw new RuntimeException("User doesn't exist");
        }
        return user;
    }

    public List<User> getUsers(List<String> userIds) {
        List<User> users = new ArrayList<>();
        for (String email: userIds) {
            users.add(getUser(email));
        }
        return users;
    }

    public void addUser(User user) throws Exception {
        this.userRegistry.add(user);
    }

    public List<User> getAllUsers() {
        return this.userRegistry.getAll();
    }

    public void updateBalanceSheet(User user, String description) {
        if (user.getBalanceSheet() == null) {
            List<String> sheet = new ArrayList<>();
            sheet.add(description);
            user.setBalanceSheet(sheet);
        } else {
            user.getBalanceSheet().add(description);
        }
    }
}
