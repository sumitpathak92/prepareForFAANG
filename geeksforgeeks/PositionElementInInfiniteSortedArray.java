package geeksforgeeks;

/*
GFG Problem (Medium) + Amazon Interview Question : https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
* **/
public class PositionElementInInfiniteSortedArray {

    public static void main(String[] args) {

        int[] A = {3,5,7,9,10,19,32,43,55,58,60,80,90};
        System.out.println(findingRange(A, 10 ));
        // start with box of size 2

    }

    static int findingRange(int[] A, int target) {
        // first find the range
        // first start with box of size 2
        int start =0; int end=1;

        // keep doubling the range till the target element is greater than end element of that range
        while(target>A[end]) {
            int newStart = end+1;
            end = end + 2*(end-start+1);
            start = newStart;
        }

        return binarySearch(A, target, start, end);
    }
    private static int binarySearch(int[] A, int target, int i, int j) {
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(A[mid]==target)
                return mid;
            else if(A[mid]>target)
                j=mid-1;
            else {
                i=mid+1;
            }
        }
        return i;
    }
}
