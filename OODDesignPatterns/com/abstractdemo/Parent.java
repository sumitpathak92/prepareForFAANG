package OODDesignPatterns.com.abstractdemo;

public abstract class Parent {

    // we cannot have a final abstract class
    // multiple inheritance not supported in Abstract classes as well

    static int age;
    final int VALUE;

    public Parent(int age) {
        this.age = age;
        VALUE = 2223332;
    }

    static void hello(){
        System.out.println("hello world !!");
    }

    void normal() {
        System.out.println("this is a normal method!! ");
    }
    abstract void career();
    abstract void partner();
}
