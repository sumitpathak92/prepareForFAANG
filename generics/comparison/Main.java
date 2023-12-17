package generics.comparison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Student kunal = new Student(34, 90.34f);
        Student rahul = new Student(32, 94.23f);
        Student sumit = new Student(31, 93.23f);
        Student honey = new Student(23, 96.23f);
        Student anubhav = new Student(3, 74.23f);

        Student[] listOfStudents = {kunal, rahul, sumit, honey, anubhav};
        System.out.println(Arrays.asList(listOfStudents));

        Arrays.sort(listOfStudents);
        System.out.println(Arrays.asList(listOfStudents));

        if(kunal.compareTo(rahul)<0) {
            System.out.println("rahul has more marks");
        }
    }
}
