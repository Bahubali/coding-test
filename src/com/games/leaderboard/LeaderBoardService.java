package com.games.leaderboard;

import com.google.inject.internal.cglib.core.$Customizer;

import java.util.ListIterator;

public class LeaderBoardService {

    public static void main(String[] args) {
        LeaderBoard board = new LeaderBoard("flipkart-cric");
        board.upSert(User.builder().email("bahubali.n@flipkart").name("Bahubali").score(0).build());
        board.upSert(User.builder().email("smita.p@flipkart").name("Smita").score(0).build());
        board.upSert(User.builder().email("sachin.j@flipkart").name("Sachin").score(0).build());
        board.upSert(User.builder().email("anand.hi@flipkart").name("Anand").score(0).build());
        //board.upSert(User.builder().email("anusha.u@flipkart").name("Anand").score(0).build());
        board.upSert(User.builder().email("sandeep.k@flipkart").name("Anand").score(0).build());

        board.upsertScore("anand.hi@flipkart", 10);
        board.upsertScore("smita.p@flipkart", 50);
        board.upsertScore("smita.p@flipkart", 100);
        board.upsertScore("bahubali.n@flipkart", 50);
        board.upsertScore("sandeep.k@flipkart", 210);
        board.upsertScore("anand.hi@flipkart", 150);
        board.updateScoreBoard(board.getUsers().size());
        ListIterator<User> iterator = board.getUsers().listIterator();
        while (iterator.hasNext()) {
            User currentUser = iterator.next();
            if (currentUser != null)
                System.out.println("User "+currentUser.getEmail()+" has score of "+ currentUser.getScore());

        }
    }
}
