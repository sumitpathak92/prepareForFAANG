package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
LC Easy : https://leetcode.com/problems/intersection-of-two-arrays-ii/
* **/
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersectII(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length< nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i : nums1) {
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        int k = 0;
        for(int i : nums2) {
            int p = hm.getOrDefault(i, 0);
            if(p > 0) {
                nums1[k++] = i;
                hm.put(i, p-1);
            }
        }
        return Arrays.copyOf(nums1, k);
    }

    private static int[] intersectII(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; int j = 0; int k =0;
        int[] res = new int[nums1.length+ nums2.length];
        while(i<nums1.length && j< nums2.length) {
            if(nums1[i]<nums2[j]) i++;
            else if(nums2[j]<nums1[i]) j++;
            else {
                res[k] = nums1[i];
                k++;
                j++;
                i++;
            }
        }
        return Arrays.copyOf(res, k);
    }
}
