package recursion.Patterns;

public class PrintStarTriangle {

    public static void main(String[] args) {
        printInvertedTriangle(4, 0);
        printNormalTriangle(4, 0);
    }

    static void printInvertedTriangle(int r, int c) {
        if(r==0) return;
        if(c<r) {
            System.out.print("*");
            printInvertedTriangle(r, c+1);
        } else {
            System.out.println();
            printInvertedTriangle(r-1, 0);
        }
    }

    static void printNormalTriangle(int r, int c) {
        if(r==0) return;
        if(c<r) {
            printNormalTriangle(r, c+1);
            System.out.print("*");
        } else {
            printNormalTriangle(r-1, 0);
            System.out.println();
        }
    }
}
