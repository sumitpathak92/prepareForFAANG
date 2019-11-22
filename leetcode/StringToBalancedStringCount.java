package leetcode;

public class StringToBalancedStringCount {

    public static void main(String[] args) {
        String s = "RLRRLLLLRLR";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int count = 0, m = 0;
        for(int i = 0; i<s.length(); i++) {
            m += s.charAt(i) == 'L' ? 1 : -1;
            if(m==0) count ++;
        }
        return count;
    }
}
