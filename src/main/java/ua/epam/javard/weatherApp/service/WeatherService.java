package ua.epam.javard.weatherApp.service;

import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Oleksii_Kovetskyi on 5/3/2018.
 *
 * Service for getting weather data
 */
public interface WeatherService {

    /**
     * Returns list of Weather entities for the given day
     * @param cityId id of a city
     * @param date date to get weather for
     * @return list of Weather entities for the given day
     */
    List<WeatherBasicEntity> getWeatherForDate(Long cityId, LocalDate date);

    /**
     * Returns list of Weather entities for the given day
     * @param cityId id of a city
     * @param period period to get weather forecast for
     * @return list of Weather entities for the given period
     */
    List<WeatherBasicEntity> getWeatherForecast(Long cityId, Period period);

    /**
     * Returns list of Weather entities for the given day
     * @param cityId id of a city
     * @param hours period to get weather forecast for
     * @return list of Weather entities for the given number of hours
     */
    List<WeatherBasicEntity> getWeatherForecast(Long cityId, int hours);

    enum Period {
        TWO_DAYS(48),
        FIVE_DAYS(120),
        WEEK(168),
        TWO_WEEKS(336),
        MONTH(720);

        private int hours;

        Period(int hours) {
            this.hours = hours;
        }

        public int getHours() {
            return hours;
        }
    }
}
