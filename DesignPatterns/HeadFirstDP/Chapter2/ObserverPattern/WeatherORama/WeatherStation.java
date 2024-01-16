package DesignPatterns.HeadFirstDP.Chapter2.ObserverPattern.WeatherORama;

public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(100.34f, 34.56f, 89.98f);


        weatherData.setMeasurements(23.34f, 31.45f, 45.32f);


    }
}
