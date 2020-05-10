package leetcode.MayChallenge.Week2;

public class CheckStraightLine {

    public static void main(String[] args) {
        int[][] coord = {{1,1}, {2,2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(checkStraightLine(coord));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[1];
        int[] point2 = coordinates[0];
        float gSlope = getSlope(point1, point2);
        for(int i = 1; i<coordinates.length; i++) {
            int[] c2 = coordinates[i];
            int[] c1 = coordinates[0];
            float slope = getSlope(c1, c2);
            if(slope!=gSlope) return false;
        }
        return true;
    }

    public static float getSlope(int[] c1, int[] c2) {
        if ((c1[0] - c2[0]) == 0) return 0;
        return (float) (c2[1]-c1[1])/(c2[0]-c1[0]);
    }
}
