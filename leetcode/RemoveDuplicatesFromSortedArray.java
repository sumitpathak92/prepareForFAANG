package leetcode;

/**

 LC Easy : https://leetcode.com/problems/remove-duplicates-from-sorted-array/

 **/
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] A = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(A));
    }

    public static int removeDuplicates(int[] A) {
        int curr = 0; int runner = 1;
        while(runner<A.length) {
            if(A[runner]!=A[curr]) {
                curr++;
                A[curr]=A[runner];
            }
            runner++;
        }
        return curr+1;
    }
}
