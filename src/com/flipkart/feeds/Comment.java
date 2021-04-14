package com.flipkart.feeds;

public class Comment {
    private int id;
    private String content;
    private User commentedBy;

    Comment(int id, String text, User addedBy) {
        this.id = id;
        this.content = text;
        this.commentedBy = addedBy;
    }
}
