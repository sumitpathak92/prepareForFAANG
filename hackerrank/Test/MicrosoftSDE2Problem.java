package hackerrank.Test;

import java.io.PrintWriter;

public class MicrosoftSDE2Problem {

    public static void main(String[] args) {
        String value = "8981";
        int sum = 0;
        String minimumHex = "FFFFFFFFFFFF";
        while(true) {
            for(char c : value.toCharArray()) {
                sum+= Character.getNumericValue(c);
            }
            String hex = Integer.toHexString(sum);
            System.out.println("123   "+ hex);
            if(hex.compareTo(minimumHex)<0 && hex.length()==1) {
                minimumHex = hex;
                System.out.println("hex val   "+hex);
                break;
            } else {
                value = hex;
            }

        }

        System.out.println(minimumHex);
//        System.out.println(hex);
//        int hextToInt = Integer.parseInt(hex, 16);
//        System.out.println(hextToInt);
    }
}
