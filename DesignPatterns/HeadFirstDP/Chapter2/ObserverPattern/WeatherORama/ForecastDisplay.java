package DesignPatterns.HeadFirstDP.Chapter2.ObserverPattern.WeatherORama;

public class ForecastDisplay implements Observer{

    private float temperature;
    private float humidity;
    private float pressure;

    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        display();
    }

    // TODO : change forecast logic
    public void display() {
        System.out.println("Current Forecast : "+temperature + "  F degrees  " + humidity  + " % humidity and " +pressure + " P pressure ");
    }
}
