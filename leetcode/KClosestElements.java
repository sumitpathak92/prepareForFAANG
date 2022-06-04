package leetcode;


import java.util.*;

/**
 *
 * LC Medium : https://leetcode.com/problems/find-k-closest-elements/
 * **/

public class KClosestElements {

    public static void main(String[] args) {
        int[] A = {1,2,3,5,6,7};
        System.out.println(findClosestElementsBinarySearch(A, 4, 4));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0]==b[0]) {
                return b[1]-a[1];
            } else {
                return b[0]-a[0];
            }
        });
        for(int i = 0; i< arr.length; i++) {
            pq.add(new int[]{Math.abs(arr[i]-x), arr[i]});
            if(pq.size()>k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        Collections.sort(res);
        return res;
    }


    public static List<Integer> findClosestElementsBinarySearch(int[] A, int k, int x) {
        int l = 0; int r = A.length-1;
        while(l<r) {
            int mid = l+(r-l)/2;
            if(A[mid]>=x) {
                r = mid-1;
            } else
                l = mid+1;
        }
//        System.out.println(ind);
        l -=1; r = l+1;
        List<Integer> res = new ArrayList<>();
        while(r-l-1<k) {
            if(r==A.length || Math.abs(A[r]-x) >= Math.abs(x-A[l])){
                l--;
            } else {
                r++;
            }
        }
        for(int i = l+1; i<r; i++) {
            res.add(A[i]);
        }
        return res;
    }
}


