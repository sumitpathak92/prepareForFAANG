package OODDesignPatterns.com.staticExample;

public class Human {


    int age; // class variables
    String name; // class variables
    int salary; // class variables
    boolean married; // class variables
    static long population;

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population+=1;
    }

}
