package recursion.arrays;

public class SortedArray {

    public static void main(String[] args) {
        int[] A = {3,5,7,8,6,34};
        System.out.println(isSorted(A, 0));
    }

    static boolean isSorted(int[] A, int index) {
        // base condition
        if(index==A.length-1) return true;
        return A[index]<A[index+1] && isSorted(A, index+1);
    }
}
