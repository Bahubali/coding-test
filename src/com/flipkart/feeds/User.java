package com.flipkart.feeds;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private int id;
    private String email;
    private String name;
    private List<Feed> posts;
    private List<User> followedBy;

    User(String email, String name) {
        this.email = email;
        this.name = name;
        this.posts = new ArrayList<>();
        this.followedBy = new ArrayList<>();
    }

    public void addFollower(User user) {
        this.followedBy.add(user);
    }
}
