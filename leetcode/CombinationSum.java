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

    public static List<List<Integer>> combinationSum(int[] A, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(A, ans, new ArrayList<>(), A.length-1, target);
        return ans;
    }

    private static void f(int[] A, List<List<Integer>> ans, List<Integer> comb, int i, int target) {
        if(i==-1) {
            if(target==0)
                ans.add(new ArrayList<>(comb));
            return;
        }
        if(A[i]<=target) {
            comb.add(A[i]);
            f(A, ans, comb, i, target-A[i]);
            comb.remove(comb.size()-1);
        }
        f(A, ans, comb, i - 1, target);

    }


}
