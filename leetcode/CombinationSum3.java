package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/combination-sum-iii/
* **/
public class CombinationSum3 {

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // we will start with 1
        List<Integer> comb = new ArrayList<>();
        combination(ans, comb, k, 1, n);
        return ans;
    }

    private static void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if(comb.size()>k) return;
        if(comb.size() == k && n==0) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i = start; i<=9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size()-1);
        }
    }

}
