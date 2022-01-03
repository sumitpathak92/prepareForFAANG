package OODDesignPatterns.com.Polymorphism;

public class Main {

    public static void main(String[] args) {

        Shapes shapes = new Shapes();
        Circle circle = new Circle();
        Shapes square = new Square();

        // polymorphism, act of representing same thing in multiple forms like the area() method below
        square.area();
    }
}
