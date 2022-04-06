package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] A = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(A, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] A, int target) {
        Arrays.sort(A);
        List<List<Integer>> ans = new ArrayList<>();
        f(0, target, A, ans, new ArrayList<>());
        return ans;
    }

    public static void f(int i, int target, int[] A, List<List<Integer>> ans, List<Integer> comb) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int j = i; j < A.length; j++) {
            if (j > i && A[j] == A[j - 1]) continue;
            if(target-A[j]<0) continue;
            comb.add(A[j]);
            f(j + 1, target - A[j], A, ans, comb);
            comb.remove(comb.size() - 1);
        }
    }


}
