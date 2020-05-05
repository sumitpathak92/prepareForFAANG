package leetcode.MayChallenge;

public class NumberComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement2(5));
    }

    public static int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        int n = bin.length();
        int res = 0;
        for(int i = 0; i<n; i++) {
            res=(res<<1)+(bin.charAt(i)=='0'?1:0);
        }
        return res;
    }

    public static int findComplement2(int N) {
        String str = Integer.toString(N,2);
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) =='0'){
                sb.append(1);}
            if(str.charAt(i) == '1'){
                sb.append(0);}
        }
        String nw = sb.toString();

        int result = Integer.parseInt(nw,2);
        return result;
    }

}
