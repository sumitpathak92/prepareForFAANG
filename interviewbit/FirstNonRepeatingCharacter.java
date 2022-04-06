package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "aabc";
        System.out.println(firstNonRepeating(s));
    }

    public static String firstNonRepeating(String s) {
        int n = s.length();
        int[] visited = new int[26];
        StringBuilder sb = new StringBuilder();
        List<Character> order = new ArrayList<>();
        for(int i=0;i<n; i++) {
            if(visited[s.charAt(i)-'a']==0)
                order.add(s.charAt(i));
            visited[s.charAt(i)-'a']++;
            int freq = 0;
            for(char c : order) {
                if(visited[c-'a']==1) {
                    sb.append(c);
                    freq=1;
                    break;
                }
            }
            if(freq==0)
                sb.append('#');
        }
        return sb.toString();
    }
}
