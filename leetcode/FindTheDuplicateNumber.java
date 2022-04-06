package leetcode;

import java.util.HashSet;

/**
 * LC Medium : https://leetcode.com/problems/find-the-duplicate-number/
 * **/
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] A = {3,1,3,4,2};
        System.out.println(findDuplicate(A));
    }

    public static int findDuplicate(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : A) {
            if(set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}
