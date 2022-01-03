package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/4sum/
* **/
public class FourSum {

    public static void main(String[] args) {
        int[] A = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(A, target));
    }

    public static List<List<Integer>> fourSum(int[] A, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(A==null || A.length < 4) return result;
        Arrays.sort(A);
        for(int i = 0; i<A.length; ++i) {
            if(i>0 && A[i]==A[i-1]) continue; // prevents duplicates first pick
            for(int j = i+1; j<A.length; ++j) {
                if(j>i+1 && A[j]==A[j-1]) continue; // prevents duplicates second pick

                // 2sum logic
                int third = j+1; int fourth = A.length-1;
                while(third<fourth) {
                    int res = A[i] + A[j] + A[third] + A[fourth];
                    if(res==target) {
                        result.add(Arrays.asList(A[i], A[j], A[third], A[fourth]));
                        third++;
                        while(third<fourth && A[third-1]==A[third]) third++; // skipping duplicates
                    }
                    else if(res>target) {
                        fourth -- ;
                    }
                    else {
                        third++;
                    }
                }
            }
        }
        return result;
    }
}
