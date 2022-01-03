package OODDesignPatterns.com.Singleton;

public class Singleton {

    private Singleton () {
        System.out.println("Do something!!");
    }

    private static Singleton instance;
    public static Singleton getInstance() {
        // check whether only one object is created
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
