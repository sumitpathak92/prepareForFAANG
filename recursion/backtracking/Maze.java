package recursion.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Maze {

    public static void main(String[] args) {
//        System.out.println(count(3,3));
//        System.out.println(pathWithDiagonal("", 3,3)) ;

        boolean[][] maze = {{true, true, true}, {true, false, true}, {true, true, true}};
        pathWithObstacle("", maze, 0,0);
    }

    static int count(int r, int c) {
        if(r==1 || c==1) {
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return right+left;
    }

    static List<String> path(String p, int r, int c) {
         if(r==1 && c==1) {
             List<String> ll = new ArrayList<>();
//             System.out.println(p);
             ll.add(p);
             return ll;
         }
         List<String> ans = new ArrayList<>();
         if(r>1) {
             ans.addAll(path(p+'D', r-1, c));
         }
         if(c>1) {
             ans.addAll(path(p+'R', r, c-1));
         }
         return ans;
    }

    static List<String> pathWithDiagonal(String p, int r, int c) {
        if(r==1 && c==1) {
            List<String> ll = new ArrayList<>();
//             System.out.println(p);
            ll.add(p);
            return ll;
        }
        List<String> ans = new ArrayList<>();
        if(r>1 && c>1) {
            ans.addAll(pathWithDiagonal(p+'V', r-1, c-1));
        }
        if(r>1) {
            ans.addAll(pathWithDiagonal(p+'D', r-1, c));
        }
        if(c>1) {
            ans.addAll(pathWithDiagonal(p+'R', r, c-1));
        }
        return ans;
    }

    static void pathWithObstacle(String p, boolean[][] maze, int r, int c) {
        if(r==maze.length-1 && c==maze[0].length-1) {
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return;
        if(r<maze.length-1) {
            pathWithObstacle(p+'D', maze, r+1, c);
        }
        if(c<maze[0].length-1) {
            pathWithObstacle(p+'R', maze, r, c+1);
        }
    }
}
