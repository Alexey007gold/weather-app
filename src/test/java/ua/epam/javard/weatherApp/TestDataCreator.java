package ua.epam.javard.weatherApp;

import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;

import java.time.LocalDateTime;

/**
 * Created by Oleksii_Kovetskyi on 5/2/2018.
 */
public class TestDataCreator {

    public static WeatherBasicEntity createWeatherBasicEntity(LocalDateTime dateTime,
                                                              Double tempCelsius, Double tempFeelsLikeCelsius) {
        WeatherBasicEntity weatherBasicEntity = new WeatherBasicEntity();
        weatherBasicEntity.setDateTime(dateTime);
        weatherBasicEntity.setTempCelsius(tempCelsius);
        weatherBasicEntity.setTempFeelsLikeCelsius(tempFeelsLikeCelsius);

        return weatherBasicEntity;
    }

    public static WeatherDetailsEntity createWeatherDetailsEntity(String weatherIconCode, Integer weatherCode,
                                                                  String weatherDescription, String windDirAbbr,
                                                                  String windDirFull, Long windDirDegrees,
                                                                  Double windSpeed, Double windGustSpeed,
                                                                  Double pressure, Long humidity) {
        WeatherDetailsEntity weatherDetailsEntity = new WeatherDetailsEntity();
        weatherDetailsEntity.setWeatherIconCode(weatherIconCode);
        weatherDetailsEntity.setWeatherCode(weatherCode);
        weatherDetailsEntity.setWeatherDescription(weatherDescription);
        weatherDetailsEntity.setWindDirAbbr(windDirAbbr);
        weatherDetailsEntity.setWindDirFull(windDirFull);
        weatherDetailsEntity.setWindDirDegrees(windDirDegrees);
        weatherDetailsEntity.setWindSpeed(windSpeed);
        weatherDetailsEntity.setWindGustSpeed(windGustSpeed);
        weatherDetailsEntity.setPressure(pressure);
        weatherDetailsEntity.setHumidity(humidity);

        return weatherDetailsEntity;
    }
}
