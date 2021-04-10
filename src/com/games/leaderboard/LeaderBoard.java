package com.games.leaderboard;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class LeaderBoard {

    private String boardId;
    private List<User> users;
    private ConcurrentSkipListMap<String, Integer> userIndex;
    private SortedMap<Integer, List<Integer>> scoreMap;

    LeaderBoard(String boardId) {
        this.boardId = boardId;
        this.users = new ArrayList<>();
        this.users.add(0, null);
        this.userIndex = new ConcurrentSkipListMap<>();
        this.scoreMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void upSert(User user) {
        if (userIndex.containsKey(user.getEmail())) {
            List<Integer> usersWithScore = scoreMap.get(user.getScore());
            if (usersWithScore == null) {
                usersWithScore = new ArrayList<>();
                usersWithScore.add(users.indexOf(user));
                scoreMap.put(user.getScore(), usersWithScore);
            } else {
                usersWithScore.add(users.indexOf(user));
                scoreMap.put(user.getScore(), usersWithScore);
            }
        } else {
            users.add(user);
            userIndex.put(user.getEmail(), users.indexOf(user));
            List<Integer> usersWithScore = scoreMap.get(user.getScore());
            if (usersWithScore == null) {
                usersWithScore = new ArrayList<>();
                usersWithScore.add(users.indexOf(user));
                scoreMap.put(user.getScore(), usersWithScore);
            } else {
                usersWithScore.add(users.indexOf(user));
                scoreMap.put(user.getScore(), usersWithScore);
            }
        }
    }
    
    public void upsertScore(String userEmail, int score) {
//        if (userIndex.containsKey(userEmail)) {
//            int currentIndex = userIndex.get(userEmail);
//            User user = users.get(currentIndex);
//            int latestScore = user.getScore() + score;
//            user.setScore(latestScore);
//            updateScoreBoard(currentIndex);
//        }

        if (userIndex.containsKey(userEmail)) {
            int userIdx = userIndex.get(userEmail);
            User user = users.get(userIdx);
            List<Integer> usersWithScore = scoreMap.get(user.getScore());
            usersWithScore.remove(new Integer(userIdx));
            user.setScore(user.getScore()+score);
            upSert(user);
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

    public SortedMap<Integer, List<Integer>> getScores() {
        return this.scoreMap;
    }
}
