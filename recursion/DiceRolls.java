package recursion;

import java.util.ArrayList;

/**
 * LC Medium : https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * **/
public class DiceRolls {

    public static void main(String[] args) {
        System.out.println(diceFace("", 4, 4));
    }


    static void diceCOmb(String p, int target) {
        if(target==0) {
            System.out.println(p);
            return;
        }

        for(int i = 1; i<=6 && i<=target; i++) {
            diceCOmb(p+i, target-i);
        }
    }

    static ArrayList<String> dice(String p, int target) {
        if(target==0) {
            ArrayList<String> al = new ArrayList<>();
            al.add(p);
            return al;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i<=6 && i<=target; i++) {
            ans.addAll(dice(p+i, target-i));
        }
        return ans;
    }


    static ArrayList<String> diceFace(String p, int target, int faces) {
        if(target==0) {
            ArrayList<String> al = new ArrayList<>();
            al.add(p);
            return al;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i<=faces && i<=target; i++) {
            ans.addAll(diceFace(p+i, target-i, faces));
        }
        return ans;
    }
//    public int numRollsToTarget(int n, int k, int target) {
//
//    }
}
