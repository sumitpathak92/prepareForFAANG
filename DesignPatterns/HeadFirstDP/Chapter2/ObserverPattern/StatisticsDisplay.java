package DesignPatterns.HeadFirstDP.Chapter2.ObserverPattern;

public class StatisticsDisplay implements Observer{

    private float temperature;
    private float humidity;
    private float pressure;

    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;

    }

    public void display() {
        System.out.println("Current Statistics : "+temperature + "  F degrees  " + humidity  + " % humidity and " +pressure + " P pressure ");
    }
}
