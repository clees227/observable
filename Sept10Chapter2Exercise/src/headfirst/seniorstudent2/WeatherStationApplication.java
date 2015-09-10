/*
 * WeatherStationApplication.java 1.0 Sept 10, 2015
 *
 * Copyright (c) 2015 HFDP and DJP
 */

package headfirst.seniorstudent2;

/**
 * WeatherData can publish changes in data to 0 or more Observers.
 * This application demonstrates the creation of 4. Since there is no
 * automatic update of WeatherData instance, the application creates a
 * control gui to allow the tester to change the current weather data
 * values to verify updates are made.
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */
public class WeatherStationApplication {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();

    new CurrentConditionsDisplay(weatherData, 300, 10);

    new CurrentConditionsDisplay(weatherData, 300, 150);

    new CurrentConditionsDisplay(weatherData, 300, 290);

    new CurrentConditionsDisplay(weatherData, 300, 440);

    new WeatherStationControlGUI(weatherData);
  }
}
