package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Second {

    static int[] input = {1, 2, 3};
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        subsets(input);
        System.out.println("Output is ::::  "+res);
        //f(0, res);
    }

    public static void f(int i, List<Integer> A) {
        if(i>= input.length) {
            System.out.println("printing one subsequence :::  "+ A);
            return;
        }
        // add this to the current subsequence
        A.add(input[i]);
        f(i+1, A);

        // remove this from current subsequence
        A.remove(A.size()-1);
        f(i+1, A);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        f(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    public static void f(int i, int[] A, List<List<Integer>> res, List<Integer> sub) {
        if(i>=A.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(A[i]);
        f(i+1, A, res, sub);

        sub.remove(sub.size() - 1);
        f(i+1, A, res, sub);
    }
}
