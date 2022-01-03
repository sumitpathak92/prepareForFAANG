package recursion.arrays;

public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] A = {5,6,7,8,9,1,2,3};
        System.out.println(search(A, 4, 0, A.length-1));
    }

    static int search(int[] A, int target, int s, int e) {
        if(s>e) return -1;
        int m = s+(e-s)/2;
        if(A[m]==target) return m;
        if(A[s]<=A[m]) {
            if(target>=A[s] && target<=A[m]) {
                return search(A, target, s, m-1);
            } else {
                return search(A, target, m+1, e);
            }
        }

        if(target>=A[m] && target<=A[e]) {
            return search(A, target, m+1, e);
        }
        return search(A, target, s, m-1);
    }
}
