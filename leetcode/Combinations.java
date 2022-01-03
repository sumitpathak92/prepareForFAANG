package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/combinations/
* **/
public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        helper(res, comb, 1, k, n);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> comb, int start, int k, int n) {
        if(comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if(comb.size()>k) return;

        for(int i=start; i<=n; i++) {
            comb.add(i);
            helper(res, comb, i+1, k, n);
            comb.remove(comb.size()-1);
        }
    }
}
