package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/permutations/
* **/
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res, comb, nums);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> comb, int[] nums) {
        if(comb.size()==nums.length) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(comb.contains(nums[i])) continue;
            comb.add(nums[i]);
            helper(res, comb, nums);
            comb.remove(comb.size()-1);
        }
    }
}
