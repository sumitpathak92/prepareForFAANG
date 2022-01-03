package leetcode;

/*
LC Hard : https://leetcode.com/problems/split-array-largest-sum/
* **/
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] A = {7,2,5,10,8};
        System.out.println(splitArray(A, 2));
    }

    public static int splitArray(int[] A, int m) {
        int start = 0; int end = 0;
        for(int i = 0; i<A.length; i++) {
            start=Math.max(start, A[i]);
            end+=A[i];
        }

        while(start<end) {
            int mid = start+(end-start)/2;
            int sum = 0; int pieces = 1;
            for(int num : A) {
                if(num+sum>mid) {
                    sum=num;
                    pieces++;
                } else sum+=num;
            }
            if(pieces>m) {
                start=mid+1;
            } else {
                end=mid;
            }
        }
        return end;
    }
}
