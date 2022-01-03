package OODDesignPatterns.com.staticExample;

public class Main {

    public static void main(String[] args) {
        Human sumit = new Human(22, "Sumit", 100000, false);
        Human rahul = new Human(23, "Rahul", 132222, true);
        Human arpit = new Human(25, "Arpit", 334444, true);

        System.out.println(Human.population);
        System.out.println(Human.population);
        System.out.println(Human.population);

        greeting(); // we cant use this because it requires an instance, but the function you
        // are using it in does not depend on instances
    }

    // we know that something which is non static belongs to an object
    static void greeting() {
        System.out.println("Hello world");
    }
}
