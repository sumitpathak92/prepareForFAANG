package dynamicProgramming.FinalTake;

import static dynamicProgramming.FinalTake.SubsetSum.subsetSumExists;

/**
 * The problem is to check if there are two subsets possible with equal sum , if yes return true, else false.
 * **/
public class EqualSumPartitionProblem {

    public static void main(String[] args) {
        int[] A = {1,7,9,5};
        System.out.println(equalSumPartition(A));
    }

    public static boolean equalSumPartition(int[] A) {
        int sum = 0;
        for(int i : A) {
            sum+=i;
        }
        System.out.println(sum);
        if(sum%2==0) {
            return subsetSumExists(A, sum/2);
        }
        return false;
    }
}
