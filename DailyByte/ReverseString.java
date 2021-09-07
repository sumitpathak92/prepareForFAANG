package DailyByte;

public class ReverseString {

    public static void main(String[] args) {
        String input = "Cat";
        System.out.println("reversed string is ::::   "+reverseString(input));
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
