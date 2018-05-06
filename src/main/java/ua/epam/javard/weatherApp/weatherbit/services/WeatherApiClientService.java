package ua.epam.javard.weatherApp.weatherbit.services;

/**
 * Service for fetching weather from open api
 */
public interface WeatherApiClientService {

    /**
     * Fetches data from weatherbit and update data in database
     * for 48 hours
     */
    void updateDbWithWeatherData();
}