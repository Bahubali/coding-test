package com.flipkart.feeds;
import java.util.*;
import java.util.stream.Collectors;


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

    public List<Feed> getLatestFeeds() {
        List<Feed> feeds = this.feeds.values().stream().collect(Collectors.toList());
        Collections.sort(feeds, new Comparator<Feed>() {
            @Override
            public int compare(Feed o1, Feed o2) {
                if (o1.getCreatedAt().getTime() > o2.getCreatedAt().getTime()) {
                    return (o1.getScore() < o2.getScore())? 1 : -1;
                }
                return -1;
            }
        });
        return feeds;
    }

    private int getFeedId() {
        return this.feeds.size() + 1;
    }

    public static void main(String[] args) {
        FeedService feedService = new FeedService();
        feedService.userSignUp(new User("tom@fk.com", "Tom"));
        feedService.userSignUp(new User("jim@fk.com", "Jimmy"));
        feedService.userSignUp(new User("karan@fk.com", "Karan"));
        feedService.login("karan@fk.com");
        feedService.postFeed("Happy Ugadi All!");
        feedService.login("tom@fk.com");
        feedService.reply(1, "Same to you!");
        feedService.postFeed("Happy Weekend!");
        feedService.login("jim@fk.com");
        feedService.reply(1, "Same here!");

        feedService.getLatestFeeds().stream().forEach(feed -> {
            System.out.println(feed.getContent());
            System.out.println("Comments :");
            feed.getComments().stream().forEach(comment -> {
                System.out.println(comment.getContent());
            });
        });
    }
}
