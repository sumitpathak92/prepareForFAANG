package leetcode;

/*
LC Easy : https://leetcode.com/problems/find-smallest-letter-greater-than-target/

* **/
public class SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] A = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(A, 'd'));
    }

    public static char nextGreatestLetter(char[] A, char target) {

        int start = 0; int end = A.length-1; int res=0;
        if(target>A[A.length-1]) return A[0];
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(A[mid]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return A[start%A.length];
    }
}
