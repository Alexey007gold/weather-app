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
            WeatherBasicEntity basicEntity = new WeatherBasicEntity();
            WeatherDetailsEntity detailsEntity = new WeatherDetailsEntity();

            detailsEntity.setWeatherIconCode(obsevation.getWeather().getIcon());
            detailsEntity.setWeatherCode(obsevation.getWeather().getCode());
            detailsEntity.setWeatherDescription(obsevation.getWeather().getDescription());
            detailsEntity.setWindDirAbbr(obsevation.getWindDirectionAbbreviation());
            detailsEntity.setWindDirFull(obsevation.getWindDirection());
            detailsEntity.setWindDirDegrees(obsevation.getWindDirectionDegrees());
            detailsEntity.setWindSpeed(obsevation.getWindSpeed());
            detailsEntity.setWindGustSpeed(obsevation.getWindGustSpeed());
            detailsEntity.setPressure(obsevation.getPressure());
            detailsEntity.setHumidity(obsevation.getRelativeHumidity());

            basicEntity.setDateTime(LocalDateTime.parse(obsevation.getDatetime(), FORMATTER));
            basicEntity.setTempCelsius(obsevation.getTemperature());
            basicEntity.setTempFeelsLikeCelsius(obsevation.getApparentTemperature());
            basicEntity.setWeatherDetailsEntity(detailsEntity);

            entityList.add(basicEntity);
        });
        return entityList;
    }
}