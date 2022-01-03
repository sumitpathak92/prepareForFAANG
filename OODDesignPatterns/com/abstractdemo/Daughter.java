package OODDesignPatterns.com.abstractdemo;

public class Daughter extends Parent{


    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("I awill become an engineer  ");
    }

    @Override
    void partner() {
        System.out.println("I will make iron ma my partner");
    }
}
