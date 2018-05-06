package ua.epam.javard.weatherApp.weatherbit.services;

import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;
import ua.epam.javard.weatherApp.weatherbit.pojo.ApiResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ApiResponseConverter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd':'HH");

    public static List<WeatherBasicEntity> fromApiResponse(ApiResponse response){
        List<WeatherBasicEntity> entityList = new ArrayList<>();

        response.getData().forEach(obsevation -> {
            WeatherDetailsEntity detailsEntity = WeatherDetailsEntity.builder()
                    .weatherIconCode(obsevation.getWeather().getIcon())
                    .weatherCode(obsevation.getWeather().getCode())
                    .weatherDescription(obsevation.getWeather().getDescription())
                    .windDirAbbr(obsevation.getWindDirectionAbbreviation())
                    .windDirFull(obsevation.getWindDirection())
                    .windDirDegrees(obsevation.getWindDirectionDegrees())
                    .windSpeed(obsevation.getWindSpeed())
                    .windGustSpeed(obsevation.getWindGustSpeed())
                    .pressure(obsevation.getPressure())
                    .humidity(obsevation.getRelativeHumidity())
                    .build();

            WeatherBasicEntity basicEntity = WeatherBasicEntity.builder()
                    .dateTime(LocalDateTime.parse(obsevation.getDatetime(), FORMATTER))
                    .tempCelsius(obsevation.getTemperature())
                    .tempFeelsLikeCelsius(obsevation.getApparentTemperature())
                    .weatherDetailsEntity(detailsEntity)
                    .build();

            entityList.add(basicEntity);
        });
        return entityList;
    }
}