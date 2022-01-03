package OODDesignPatterns.com.Inheritance;

public class Main {

    public static void main(String[] args) {

//        Box box1 = new Box(4, 6.7, 43 );
//        Box box2 = new Box(box1);
//        System.out.println(box2.l);
//        System.out.println(box2.w);
//        System.out.println(box2.h);
//
//        BoxWeight boxWeight = new BoxWeight();
//        System.out.println(boxWeight.weight + " " +boxWeight.h + " " + boxWeight.l);
//

//        Box box5 = new BoxWeight(2,3,4,8);

        // it is actually the type of reference variables that will determine the access to properties
        // not the type of object that determines access
        // System.out.println(box5.weight); hence this line will give error


        // there are many variables in child classes
        // you are given access to variables in the ref type ie BoxWeight
        // hence, you should have access to weight variable
        // box class doesn't know the child classes, hence the error
        // BoxWeight box6 = new Box(2,3,4);

        BoxPrice box = new BoxPrice(5, 8, 200);


    }



}
