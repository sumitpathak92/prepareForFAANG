package OODDesignPatterns.com.Inheritance;

public class BoxWeight extends Box{

    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(Box box) {

    }

    public BoxWeight(double side, double weight) {
        super(side);
        this.weight=weight;
    }
    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w); // in order to send length, height, width, it basically calls the parent class controller
        // used to initialize value present in parent class
        this.weight = weight;
    }
}
