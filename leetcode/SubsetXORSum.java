package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * LC EASY : https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 * */
public class SubsetXORSum {

    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(subsetXORSum(nums));
    }

    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetHelper(nums, res, new ArrayList<>(), 0);
        System.out.println(res);
        int sum=0;
        for(List<Integer> l : res) {
            int[] A = l.stream().mapToInt(i->i).toArray();
            sum+=xorOfArray(A, A.length);
        }
        return sum;
    }

    public static void subsetHelper(int[] nums, List<List<Integer>> res, List<Integer> subset, int idx) {
        res.add(new ArrayList<>(subset));
        for(int i =idx ; i<nums.length; i++) {
            subset.add(nums[i]); // first choice, include element in the subset
            subsetHelper(nums, res, subset, i+1);
            subset.remove(subset.size()-1); // second choice, remove element from this subset
        }
    }

    static int xorOfArray(int arr[], int n)
    {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
}
