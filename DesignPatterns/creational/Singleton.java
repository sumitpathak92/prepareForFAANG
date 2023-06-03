package DesignPatterns.creational;

public class Singleton {

    private static Singleton singleton;

    private Singleton() {
        // constructor should not be accessible from outside the class, hence made private
    }

    public static Singleton getInstance() {
        if(singleton==null)
            singleton = new Singleton();
        return singleton;
    }

}
