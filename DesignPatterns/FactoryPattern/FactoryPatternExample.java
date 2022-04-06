package DesignPatterns.FactoryPattern;

abstract class Vehicle {

    public abstract int getWheel();

    public String toString(){
        return "Wheels:  "+this.getWheel();
    }
}

class Car extends Vehicle {

    private int wheels;
    Car(int wheels) {
        this.wheels = wheels;
    }
    @Override
    public int getWheel() {
        return this.wheels;
    }
}

class Bike extends Vehicle {

    private int wheels;
    Bike(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public int getWheel() {
        return this.wheels;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type, int wheels) {
        if(type.equals("car"))
            return new Car(wheels);
        if(type.equals("bike"))
            return new Bike(wheels);
        return null;
    }
}

public class FactoryPatternExample { // client class
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        Vehicle bike = VehicleFactory.getInstance("bike", 2);

        System.out.println(car);
        System.out.println(bike);
    }
}
