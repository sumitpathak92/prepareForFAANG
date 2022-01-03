package OODDesignPatterns.com.Singleton;

public class Main {

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();

        // all three reference variables are pointing to one object
    }
}
