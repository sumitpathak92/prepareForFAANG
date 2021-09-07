package leetcode;

/*
LC Medium :
* **/
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(matrix, 599));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // this approach follows Binary Search Algorithm
        // BS for the element in each row since they are sorted
        boolean res = false;
        for(int[] row : matrix) {
            res = binarySearch(row, target);
            if(res) break;
        }
        return res;
    }

    private static boolean binarySearch(int[] row, int target) {
        int left = 0; int right = row.length-1;
        return helper(row, left, right, target);
    }

    private static boolean helper(int[] row, int start, int end, int target) {
        if(start>end) return false;
        int mid = start + (end-start)/2;
        if(target == row[mid]) return true;
        if(target>row[mid]) {
            return helper(row, mid+1, end, target);
        }
        if(target<row[mid]) {
             return helper(row, start, mid-1, target);
        }
        return false;
    }
}
