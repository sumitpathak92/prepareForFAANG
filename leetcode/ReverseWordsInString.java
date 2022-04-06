package leetcode;


/**
 * LC Medium : https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * **/
public class ReverseWordsInString {

    public static void main(String[] args) {
        char[] A = {'h', 'e', 'r', 'o', ' ', 'i', 's', ' ', 't', 'h', 'e'};
        reverseWords(A);
        System.out.println(A);
    }

    public static void reverseWords(char[] s) {
        reverseAll(s, 0, s.length-1);
        System.out.println(s);
        reverseEachWord(s);
    }

    static void reverseAll(char[] A, int i, int j) {
        while(i<j){
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++; j--;
        }
    }

    static void reverseEachWord(char[] A) {
        int i = 0; int j = 1;
        while(j<A.length) {
            if(A[j]==' ') {
                reverseAll(A, i, j - 1);
                i = j+1;
                j=i+1;
            } else if(j==A.length-1){
                reverseAll(A, i, j);
                break;
            }
            else {
                j++;
            }
        }
    }
}
