package javaInterviewPrep.Lambda;

public class Lambdas {

    public static void main(String[] args) {

        Printable lambdaPrintable = (suffix) -> System.out.println("meooowww!!!  "+suffix);
        printThing(lambdaPrintable);

    }



    static void printThing(Printable thing) {
        thing.print("!@#@");
    }
}
