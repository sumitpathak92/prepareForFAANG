package leetcode;

/*
LC Medium : https://leetcode.com/problems/container-with-most-water/
* **/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = {2,3,4,5,18,17,6};
        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] height) {
        int i = 0; int j = height.length-1;
        int area = 0;
        int min;
        while(i<j) {
            min = Math.min(height[i], height[j]);
            int A1 = min*(j-i);
            if(A1>area) area = A1;
            if(height[i]<height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }
}
