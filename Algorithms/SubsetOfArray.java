package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Problem is to find all the subsets of a given array
 *
 * */
public class SubsetOfArray {

    private static List<List<Integer>> op = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(getSubsets(nums));
    }

    public static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> res;
        helper(nums, op, new ArrayList<>(), 0);
//        System.out.println(res);
        res = op;
        System.out.println("1222   ::  "+res);
        return res;
    }

    public static void helper(int[] nums, List<List<Integer>> op, List<Integer> curr, int idx) {
        if(idx == nums.length) {
            System.out.println("1111 ::  "+curr);
            op.add(curr);
            return;
        }
        curr.add(nums[idx]);
        helper(nums, op, curr,idx+1);
        curr.remove(curr.size()-1);
        helper(nums, op, curr, idx+1);
    }
}
