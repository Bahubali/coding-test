package com.flipkart.feeds;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Feed {
    static enum FeedType {
        IMAGE, VIDEO, TEXT;
    }
    private int id;
    private String content;
    private Status status;
    private FeedType type;
    private int upVotes;
    private int downVotes;
    private User postedBy;
    private Timestamp createdAt;
    private List<Comment> comments;

    Feed(int id, String content, FeedType type, User user) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.postedBy = user;
        this.upVotes = 0;
        this.downVotes = 0;
        this.comments = new LinkedList<>();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public int getScore() {
        int score = this.upVotes - this.downVotes;
        score += this.comments.size();
        return score;
    }

    public int getCommentId() {
        return this.comments.size() + 1;
    }
}
