package OODDesignPatterns.com.abstractdemo;

public class Main {

    public static void main(String[] args) {

        Son son = new Son(21);
        son.career();
        son.normal();

        Daughter daughter = new Daughter(12);
        daughter.career();

        Parent.hello();
        // for abstract classes we cannot create objects
        // also we cannot create abstract static methods

    }
}
