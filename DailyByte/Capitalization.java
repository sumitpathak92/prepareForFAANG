package DailyByte;

/**
 * Problem statement: Given a string, return whether or not it uses capitalization correctly.
 * A string correctly uses capitalization if all letters are capitalized, no letters are capitalized,
 * or only the first letter is capitalized.
 *
 * Example :
 * "USA", return true
 * "Calvin", return true
 * "compUter", return false
 * "coding", return true
 * */
public class Capitalization {

    public static void main(String[] args) {
        System.out.println(isValidCapitalization("compUter"));
    }

    public static boolean isValidCapitalization(String s) {
        int upperCount = 0;
        int lowerCount = 0;
        boolean[] upIndex = new boolean[s.length()];
        boolean[] lowIndex = new boolean[s.length()];
        for(int i = 0; i<s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))){
                upperCount++;
                upIndex[i] = true;
            } else {
                lowerCount++;
                lowIndex[i] = true;
            }
        }
        if(upperCount == s.length())
            return true;
        if(lowerCount == s.length())
            return true;
        return upperCount == 1 && upIndex[0];
    }
}
