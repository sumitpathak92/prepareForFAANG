package leetcode;


import java.util.Arrays;

/***
 * LC Medium : https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * */

public class PartitionToKEqualSumSubsets {

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(canPartitionKSubsets(A, 3));
    }

    public static boolean canPartitionKSubsets(int[] A, int k) {
        int s = 0;
        for(int i : A){
            s+=i;
        }
        if(s%k!=0) return false;
        int target = s/k;
        int n=A.length;
        Arrays.sort(A);
        boolean[] visited = new boolean[n];
        int index = n-1; int count = 0; int currSum = 0;
        return helper(A, index, k, count, currSum, target, visited);
    }

    public static boolean helper(int[] A, int index, int k, int count, int currSum, int target, boolean[] visited) {
        if(count==k-1) return true;
        if(currSum == target) {
            // update count and reset sum, then recurse
            return helper(A, A.length-1, k, count+1, 0, target, visited);
        }
        // else run for all the unvisited elements
        for(int i = index; i>=0; i--) {
            if(!visited[i] && currSum+A[i]<=target) {
                visited[i] = true;
                if(helper(A, i-1, k, count, currSum + A[i], target, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
