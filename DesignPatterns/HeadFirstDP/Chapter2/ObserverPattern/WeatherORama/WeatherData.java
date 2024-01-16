package DesignPatterns.HeadFirstDP.Chapter2.ObserverPattern.WeatherORama;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{

    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    List<Observer> observers = new ArrayList<>();

    /**
     * This method is called, whenever the weather
     * measurements have been updated
     *
     * */
    public void measurementsChanged() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }


    /**
     *
     * Will be called by the main function to pass new measurements to weather data object and
     * subsequently notify the observers
     *
     * */
    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
