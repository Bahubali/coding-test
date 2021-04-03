package com.games.leaderboard;

import com.google.inject.internal.cglib.core.$Customizer;

import java.util.Iterator;
import java.util.List;

public class LeaderBoardService {

    public static void main(String[] args) {
        LeaderBoard board = new LeaderBoard("flipkart-cric");
        board.upSert(User.builder().email("bahubali.n@flipkart").name("Bahubali").score(0).build());
        board.upSert(User.builder().email("smita.p@flipkart").name("Smita").score(0).build());
        board.upSert(User.builder().email("sachin.j@flipkart").name("Sachin").score(0).build());
        board.upSert(User.builder().email("anand.hi@flipkart").name("Anand").score(0).build());
        //board.upSert(User.builder().email("anusha.u@flipkart").name("Anand").score(0).build());
        board.upSert(User.builder().email("sandeep.k@flipkart").name("Sandeep").score(0).build());

        board.upsertScore("anand.hi@flipkart", 10);
        board.upsertScore("smita.p@flipkart", 50);
        board.upsertScore("smita.p@flipkart", 100);
        board.upsertScore("bahubali.n@flipkart", 50);
        board.upsertScore("sandeep.k@flipkart", 210);
        board.upsertScore("anand.hi@flipkart", 150);
        board.upsertScore("bahubali.n@flipkart", 100);
        //board.updateScoreBoard(board.getUsers().size());
        Iterator iterator = board.getScores().keySet().iterator();
        int rank = 1;
        while (iterator.hasNext()) {
            Integer score = (Integer) iterator.next();
            List<Integer> userIds = board.getScores().get(score);
            if (userIds.isEmpty()) continue;
            for (Integer userId: userIds) {
                System.out.println("Rank "+rank+" - score - "+score+" - "+board.getUsers().get(userId));
            }
            rank++;
        }
    }
}
