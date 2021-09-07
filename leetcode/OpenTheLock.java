package leetcode;

import java.util.*;

/**
 *
 * LC Medium :  https://leetcode.com/problems/open-the-lock/solution/
 * */
public class OpenTheLock {

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(" printing minimum turns ::::    "+openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String start = "0000";
        int count = 0;
        q.offer(start);
        q.offer(null);
        visited.add(start);
        while(!q.isEmpty()) {
            String s = q.poll();
            if(s==null){
                count++;
                if(q.peek()!=null)
                    q.add(null);
            } else if(s.equals(target)) return count;
            else if(!Arrays.asList(deadends).contains(s)) {
                for(int i = 0; i<4; i++) {
                    for(int d = -1; d<2; d+=2) {
                        String mid = generateString(s, i, d);
                        if(!visited.contains(mid)) {
                            visited.add(mid);
                            q.add(mid);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static String generateString(String s, int i, int d) {
        int y = ((s.charAt(i) - '0') + d + 10) %10;
        String neigh = s.substring(0, i) + ("" + y) + s.substring(i+1);
        return neigh;
    }
}
