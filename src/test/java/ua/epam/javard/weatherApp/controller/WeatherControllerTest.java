package ua.epam.javard.weatherApp.controller;

import org.junit.Before;
import org.junit.Test;
import ua.epam.javard.weatherApp.TestDataCreator;
import ua.epam.javard.weatherApp.common.Unit;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;
import ua.epam.javard.weatherApp.service.WeatherService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Oleksii_Kovetskyi on 5/6/2018.
 */
public class WeatherControllerTest {

    private WeatherController weatherController;
    private WeatherService weatherService;
    private List<WeatherBasicEntity> entities;

    @Before
    public void init() {
        weatherService = mock(WeatherService.class);
        weatherController = new WeatherController(weatherService);

        WeatherDetailsEntity weatherDetailsEntity = TestDataCreator.createWeatherDetailsEntity("icon",
                1111, "Rainy", "S", "South", 180L,
                10.5, 15.5, 90.0, 30L);

        Random random = new Random(999999999999999999L);
        entities = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            LocalDateTime dateTime = LocalDateTime.of(2018, 10, 15,
                    random.nextInt(24),  random.nextInt(60));
            WeatherBasicEntity weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(dateTime, 40.0, 40.0);
            weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);
            entities.add(weatherBasicEntity);
        }
    }

    @Test
    public void getWeatherForToday() {
        LocalDate date = LocalDate.now();
        when(weatherService.getWeatherForDate(date)).thenReturn(entities);
        List<WeatherBasicEntity> weatherForToday = weatherController.getWeatherForToday(Unit.METRIC);

        assertEquals(entities, weatherForToday);
        verify(weatherService, times(1)).getWeatherForDate(date);
    }

    @Test
    public void getWeatherForTomorrow() {
        LocalDate date = LocalDate.now().plusDays(1);
        when(weatherService.getWeatherForDate(date)).thenReturn(entities);
        List<WeatherBasicEntity> weatherForTomorrow = weatherController.getWeatherForTomorrow(Unit.METRIC);

        assertEquals(entities, weatherForTomorrow);
        verify(weatherService, times(1)).getWeatherForDate(date);
    }
}