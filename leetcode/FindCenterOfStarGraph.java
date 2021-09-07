package leetcode;

/*
LC Easy : https://leetcode.com/problems/find-center-of-star-graph/
* **/
public class FindCenterOfStarGraph {

    public static void main(String[] args) {
        int[][] edges = {{1,10}, {10,2}, {3,10}, {10,4}, {10,5}, {10,6}, {10,7}, {8, 10}, {9,10}, {10, 11}, {12, 10}};
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) return edges[0][0];
        return edges[0][1];
    }
}
