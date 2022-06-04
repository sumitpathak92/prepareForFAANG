package DesignPatterns.FromYouTube;

public class SingletonExample {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        System.out.println(instance);

        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance2);
    }

}


class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance==null)
            instance = new Singleton();
        return instance;
    }
}

class SingletonSynchronisedMethod {
    private static SingletonSynchronisedMethod instance;

    private SingletonSynchronisedMethod() {}

    public static synchronized SingletonSynchronisedMethod getInstance() {
        if(instance==null)
            instance = new SingletonSynchronisedMethod();
        return instance;
    }
}

class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {}
    public static SingletonSynchronized getInstance() {
        if(instance==null) {
            synchronized (SingletonSynchronized.class) {
                if(instance==null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}