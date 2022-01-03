package leetcode;

/**
 * LC Medium : https://leetcode.com/problems/beautiful-arrangement/
 * **/
public class BeautifulArrangement {
    public static void main(String[] args) {
        System.out.println(countArrangementOpt(3));
    }

    public static int countArrangement(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(i);
        }
        String up = sb.toString();
        return permutations("", up);
    }

    static int count=0;
    public static int countArrangementOpt(int n) {
        boolean[] visited = new boolean[n+1];
        int count1=0;
        helper(visited, 1, n);
        return count;
    }

    private static void helper(boolean[] visited, int pos, int n) {
        if(pos>n){
            count++;
            return;
        }
        for(int i = 1; i<=n; i++) {
            if(!visited[i] && (pos%i==0 || i%pos==0)) {
                visited[i] = true;
                helper(visited, pos+1, n);
                // backtrack, reset state to unvisited
                visited[i] = false;
            }
        }
    }

    static int permutations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            if(checkBeautiful(p)){
                return 1;
            }
            return 0;
        }

        char ch = up.charAt(0); int count = 0;
        for(int i = 0; i<=p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i);
            count+=permutations(first+ch+second, up.substring(1));
        }

        return count;
    }

    private static boolean checkBeautiful(String p) {
        int len = p.length();
        for(int i = 0; i<len; i++) {
            int k = Character.getNumericValue(p.charAt(i));
            if(k%(i+1)!=0 && (i+1)%k!=0) {
                return false;
            }
        }
        return true;
    }
}
