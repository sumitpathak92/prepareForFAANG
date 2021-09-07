package leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC Medium  : https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1373/
 * */


public class WallsAndGates {

    private static int[] rows = {-1, 0, 1, 0};
    private static int[] cols = {0, 1, 0, -1};
    private static int EMPTY = Integer.MAX_VALUE;
    private static int GATE = 0;
    private static int WALL = -1;

    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
//        wallsAndGates(rooms);
//        System.out.println("new grid ::::    "+ Arrays.deepToString(rooms));
        wallsAndGateII(rooms);
        System.out.println("new grid ::::    " + Arrays.deepToString(rooms));
    }

    public static void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 2147483647)
                    rooms[i][j] = bfs(rooms, i, j);
            }
        }
    }

    public static int bfs(int[][] rooms, int i, int j) {
        int[][] distance = new int[rooms.length][rooms[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            for (int p = 0; p < 4; p++) {
                int r = coord[0] + rows[p];
                int c = coord[1] + cols[p];
                if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] == -1 || distance[r][c] != 0) // distance[r][c]!=0 means it has been visited
                    continue;
                distance[r][c] = distance[coord[0]][coord[1]] + 1;
                if (rooms[r][c] == 0)
                    return distance[r][c];
                q.offer(new int[]{r, c});
            }
        }
        return 2147483647;
    }

    /**
     * This approach puts all the gates into the queue first
     * then processes it one by one and calculates distance of all empty cells from that gate
     * We will initiate BFS from all gates one by one.
     * BFS guarantees we search all rooms at distance d before d+1,
     * the distance to empty room must be shortest
     * */
    public static void wallsAndGateII(int[][] rooms) {
        if (rooms.length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == GATE) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            for (int p = 0; p < 4; p++) {
                int r = coord[0] + rows[p];
                int c = coord[1] + cols[p];
                if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] != EMPTY) // rooms[][]!=Empty
                    // is to check if room has been visited
                    continue;
                rooms[r][c] = rooms[coord[0]][coord[1]]+1;
                q.offer(new int[]{r, c});
            }
        }
    }
}


