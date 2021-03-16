package com.games.leaderboard;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class LeaderBoard {

    private String boardId;
    private List<User> users;
    private ConcurrentSkipListMap<String, Integer> userIndex;

    LeaderBoard(String boardId) {
        this.boardId = boardId;
        this.users = new ArrayList<>();
        this.users.add(0, null);
        this.userIndex = new ConcurrentSkipListMap<>();
    }

    public void upSert(User user) {
        if (userIndex.containsKey(user.getEmail())) {
            //
        } else {
            users.add(user);
            userIndex.put(user.getEmail(), users.indexOf(user));
        }
    }
    
    public void upsertScore(String userEmail, int score) {
        if (userIndex.containsKey(userEmail)) {
            int currentIndex = userIndex.get(userEmail);
            User user = users.get(currentIndex);
            int latestScore = user.getScore() + score;
            user.setScore(latestScore);
            updateScoreBoard(currentIndex);
        }
    }
    public void updateScoreBoard(int idx) {
        int index = idx;
        while (index > 1) {
            int parentIndex = Math.floorDiv(index, 2);
            if (users.get(index).getScore() > users.get(parentIndex).getScore()) {
                userIndex.put(users.get(parentIndex).getEmail(), index);
                userIndex.put(users.get(index).getEmail(), parentIndex);
                Collections.swap(users, parentIndex, index);
            }
            int leftIdx = (2 * parentIndex);
            int rightIdx = (2 * parentIndex) + 1;
            //boolean isRightIndex = (Math.floorDiv(index, parentIndex) > 1)? true : false;
            if (rightIdx == index) {
                if (users.get(rightIdx).getScore() > users.get(leftIdx).getScore()) {
                    userIndex.put(users.get(rightIdx).getEmail(), leftIdx);
                    userIndex.put(users.get(leftIdx).getEmail(), rightIdx);
                    Collections.swap(users, rightIdx, leftIdx);
                }
            }
            index = parentIndex;
        }
    }

    private boolean isLeaf(int pos) {
        if (pos > (users.size()/2) && pos <= users.size()) {
            return true;
        }
        return false;
    }
    public List<User> getUsers() {
        return this.users;
    }
}
