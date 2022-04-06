package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC Medium : https://leetcode.com/problems/subsets-ii/
 * **/
public class SubsetsII {

    public static void main(String[] args) {
        int[] A = {1,2,3, 2,4};
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(A));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        subsets(comb, ans, nums, 0);
        return ans;
    }

    void subsets(List<Integer> comb, List<List<Integer>> ans, int[] A, int index) {
        ans.add(new ArrayList<>(comb));
        for(int i = index; i<A.length; i++) {
            if(i!=index && A[i]==A[i-1]) {
                continue;
            }
            comb.add(A[i]);
            subsets(comb, ans, A, i+1);
            comb.remove(comb.size()-1);
        }
    }

}
