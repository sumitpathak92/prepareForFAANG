package javaInterviewPrep.lambdas.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class LambdaPractice {

    public static void main(String[] args) {

        SumCalculator sumCalculator = (a, b) -> a+b;
        System.out.println("Sum of two no.s :: "+ sumCalculator.add(5, 6));

        StringEmptyFinder stringEmptyFinder = str -> str == null || str.isEmpty();
        System.out.println("String is empty :::  "+ stringEmptyFinder.isStringEmpty(" "));

        List<String> input = List.of("Hello", "World", "HOW is", "everyone", "TODAY");
        input.replaceAll(s -> s.toLowerCase());
        System.out.println("Lower case output list :::  "+input);

        List<String> input2 = List.of("Hello", "World", "HOW is", "everyone", "TODAY");
        input2.replaceAll(s -> s.toUpperCase());
        System.out.println("Upper Case output list :::  "+input2);

//
//        ListOfStringsToUppercase listOfStringsToUppercase =  stringList -> {
//                List<String> result = new ArrayList<>();
//                for(String s : stringList) {
//                    result.add(s.toUpperCase());
//                }
//                return result;
//        };
//
//        System.out.println("Converted UpperCase Strings ::::  "+listOfStringsToUppercase.convertToUpperCase(input));
//
//        System.out.println("Converted LowerCase Strings ::::  " +listOfStringsToLowerCase.convertToLowerCase(input));

        List<Double> inputList = List.of(34.56, 232.34, 87.76, 31.23, 65.43);
        AverageOfDoubles averageOfDoubles = doubleList -> {
                int size = doubleList.size();
                double totalSum = 0;
                for(Double val : doubleList) {
                    totalSum+=val;
                }
                return totalSum/size;
        };

        System.out.println("Average of all doubles in the list ::::  "+averageOfDoubles.calculateAverage(inputList));

    }

}
