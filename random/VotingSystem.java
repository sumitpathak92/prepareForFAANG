package random;

import java.util.ArrayList;
import java.util.List;

public class VotingSystem {

    public static void main(String[] args) {

        // voter 1 gave these votes
        Vote v1 = new Vote("John", 1);
        Vote v2 = new Vote("Johnny", 2);
        Vote v3 = new Vote("Jennifer", 3);

        // voter 2 gave these votes
        Vote v4 = new Vote("John", 2);
        Vote v5 = new Vote("Johnny", 1);
        Vote v6 = new Vote("Jennifer", 3);

        // voter 3 gave these votes
        Vote v7 = new Vote("John", 1);
        Vote v8 = new Vote("Johnny", 3);
        Vote v9 = new Vote("Jennifer", 2);

        List<Vote> votes = new ArrayList<>();

        votes.add(v1);
        votes.add(v2);
        votes.add(v3);
        votes.add(v4);
        votes.add(v5);
        votes.add(v6);
        votes.add(v7);
        votes.add(v8);
        votes.add(v9);


    }


}

class Candidate {
    String name;
    int[] votePositions;
    boolean isWinner;
    int totalPoints;

    public Candidate(String name, int totalPoints) {
        this.name = name;
        this.totalPoints = totalPoints;
        this.isWinner = false;
        this.votePositions = new int[3];
    }
}

class Vote {
    String candidate;
    int position;

    public Vote(String candidate, int position) {
        this.candidate = candidate;
        this.position = position;
    }
}
