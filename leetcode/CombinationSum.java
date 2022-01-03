package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/combination-sum/
* **/
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        int start = 0;
        combination(candidates, ans, comb, start, target);
        return ans;
    }

    private static void combination(int[] candidates, List<List<Integer>> ans, List<Integer> comb, int start, int target) {
        if(target<0) return;
        if(0 == target) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i = start; i<candidates.length; i++) {
            int cand = candidates[i];
            comb.add(cand);
            combination(candidates, ans, comb, i, target-cand);
            // backtrack
            comb.remove(comb.size()-1);
        }
    }


}
