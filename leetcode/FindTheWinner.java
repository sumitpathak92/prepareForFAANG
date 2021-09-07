package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/find-the-winner-of-the-circular-game/
* **/
public class FindTheWinner {

    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            friends.add(i);
        }
        System.out.println(friends);
        return helper(friends, 0, k-1);
    }

    private static int helper(List<Integer> friends, int start, int k) {
        if(friends.size() == 1) return friends.get(0);
        start = (start+k)%friends.size();
        friends.remove(start);
        return helper(friends, start, k);
    }
}
