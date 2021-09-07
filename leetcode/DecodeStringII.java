package leetcode;

/*
LC Medium : https://leetcode.com/problems/decode-string/
* **/
public class DecodeStringII {

    public static void main(String[] args) {
        String input = "300[a2[c]]";
        System.out.println(decodeString(input));
    }

    public static String decodeString(String s) {
        if(s.length()==1) return s;
        StringBuilder sb = new StringBuilder();
        int open = 0; int close = 0; int j; int c;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '[') {
                j=i;
                open ++;
                while(true) {
                    i++;
                    if(s.charAt(i)==']') close++;
                    if(s.charAt(i)=='[') open++;
                    if(open==close) break;
                }
                if(j>=3 && Character.isDigit(s.charAt(j-3))) {
                    c = Integer.parseInt(s.substring(j-3, j));
                }
                else if(j>=2 && Character.isDigit(s.charAt(j-2))) {
                    c = Integer.parseInt(s.substring(j-2, j));
                } else {
                    c = Character.getNumericValue(s.charAt(j-1));
                }
                for(int p = 0; p<c; p++) {
                    sb.append(decodeString(s.substring(j+1, i)));
                }
            } else if(!Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        if(sb.length()==0) return s;
        return sb.toString();
    }
}
