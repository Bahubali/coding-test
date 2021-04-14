package com.flipkart.feeds;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class FeedService {

    private UserService userService;
    private Map<Integer, Feed> feeds;
    private User loggedInUser;

    FeedService() {
        this.userService = new UserService();
        this.feeds = new HashMap<>();
    }

    public void userSignUp(User user) {
        if (this.userService.getUser(user.getEmail()) == null)
            this.userService.registerUser(user);
    }

    public void login(String email) {
        User user = this.userService.getUser(email);
        if (user != null) {
            this.loggedInUser = user;
        }
    }
    public void follow(String user) {
        User followUser = this.userService.getUser(user);
        followUser.addFollower(this.loggedInUser);
    }

    public void postFeed(String content) {
        Feed feed = new Feed(getFeedId(), content, Feed.FeedType.TEXT, this.loggedInUser);
        if (!this.feeds.containsKey(feed.getId())) {
            this.feeds.put(feed.getId(), feed);
        }

    }

    public void reply(int id, String replyText) {
        if (this.feeds.containsKey(id)) {
            Feed feed = this.feeds.get(id);
            Comment comment = new Comment(feed.getCommentId(), replyText, this.loggedInUser);
            feed.getComments().add(comment);
        }
    }

    private int getFeedId() {
        return this.feeds.size() + 1;
    }
}
