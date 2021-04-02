package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SparseVectorMain {

    public static void main(String[] args) {
        int[] nums1 = {1,0,0,2,3};
        int[] nums2 = {0,3,0,4,0};

        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);

        int ans = v1.dotProduct(v2);
        System.out.println("answer is :::: "+ans);
    }

}

class SparseVector {

    Map<Integer, Integer> hm ;
    SparseVector(int[] nums) {
        hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]!=0) hm.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for(Integer i : hm.keySet()) {
            if(vec.hm.containsKey(i)) {
                res+=hm.get(i)*vec.hm.get(i);
            }
        }
        return res;
    }
}
