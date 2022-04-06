package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC Medium : https://leetcode.com/problems/permutations/
 * **/
public class PermutationsII {

    public static void main(String[] args) {
        int[] A = {1,2,3};
        System.out.println(permute(A));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, res, ans);
        return ans;
    }

    static void helper(int[] nums, List<Integer> res, List<List<Integer>> ans) {
        if(res.size()==nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0; i< nums.length; i++) {
            if(res.contains(nums[i])) continue;
            res.add(nums[i]);
            helper(nums, res, ans);
            res.remove(res.size()-1);
        }
    }
}
