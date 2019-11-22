package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {
        int[] array = {-2,0,1,1,2};

        System.out.println("there exist three sum -->  "+threeSumExists(array, 0));
    }

    private static List<List<Integer>> threeSumExists(int[] A, int sum) {
        // check input
        List<List<Integer>> res = new ArrayList<>();
        if(A.length<3) return res;
        Arrays.sort(A); // [-4, -1, -1, 0, 1, 2]
        for(int i = 0; i<A.length - 2; i++) {
            int remaining = sum - A[i];
            int j = i+1, k = A.length-1;
            while(j<k) {
                System.out.println(i + "  " +j + "  " +k);
                if(A[j] + A[k] == remaining) {
                    System.out.println(11122);
                    res.add(Arrays.asList(A[i], A[j], A[k]));
                    j++;
                    k--;
                }
                else if(A[j] + A[k] > remaining) k--;
                else j++;
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }
}
