package ua.epam.javard.weatherApp.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import ua.epam.javard.weatherApp.repository.WeatherBasicRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Oleksii_Kovetskyi on 5/3/2018.
 */
public class WeatherServiceImplTest {

    private WeatherServiceImpl weatherService;
    private WeatherBasicRepository weatherBasicRepository;

    @Before
    public void init() {
        weatherBasicRepository = mock(WeatherBasicRepository.class);
        weatherService = new WeatherServiceImpl(weatherBasicRepository);
    }

    @Test
    public void shouldCallRepositoryMethodWithCorrectArgumentsFromAndUntilOnGetWeatherForDateCall() {
        LocalDate date = LocalDate.now();
        weatherService.getWeatherForDate(date);

        ArgumentCaptor<LocalDateTime> captorFrom = ArgumentCaptor.forClass(LocalDateTime.class);
        ArgumentCaptor<LocalDateTime> captorUntil = ArgumentCaptor.forClass(LocalDateTime.class);
        verify(weatherBasicRepository, times(1))
                .findByDateTimeBetween(captorFrom.capture(), captorUntil.capture());
        LocalDateTime from = captorFrom.getValue();
        LocalDateTime until = captorUntil.getValue();

        assertEquals(date.getYear(), from.getYear());
        assertEquals(date.getMonthValue(), from.getMonthValue());
        assertEquals(date.getDayOfMonth(), from.getDayOfMonth());
        assertEquals(0, from.getHour());
        assertEquals(0, from.getMinute());
        assertEquals(0, from.getSecond());
        assertEquals(0, from.getNano());

        assertEquals(date.getYear(), until.getYear());
        assertEquals(date.getMonthValue(), until.getMonthValue());
        assertEquals(date.getDayOfMonth(), until.getDayOfMonth());
        assertEquals(23, until.getHour());
        assertEquals(59, until.getMinute());
        assertEquals(59, until.getSecond());
        assertEquals(999999999, until.getNano());
    }

    @Test
    public void shouldCallRepositoryMethodWithCorrectArgumentsFromAndUntilOnGetWeatherForecastCallWithEnumArg() {
        WeatherService.Period period = WeatherService.Period.WEEK;
        weatherService.getWeatherForecast(period);

        checkCallsRepositoryMethodWithCorrectArgumentsFromAndUntilOnGetWeatherForecastCall(period.getHours());
    }

    @Test
    public void shouldCallRepositoryMethodWithCorrectArgumentsFromAndUntilOnGetWeatherForecastCallWithIntArg() {
        int period = 6;
        weatherService.getWeatherForecast(period);

        checkCallsRepositoryMethodWithCorrectArgumentsFromAndUntilOnGetWeatherForecastCall(period);
    }

    private void checkCallsRepositoryMethodWithCorrectArgumentsFromAndUntilOnGetWeatherForecastCall(int period) {
        ArgumentCaptor<LocalDateTime> captorFrom = ArgumentCaptor.forClass(LocalDateTime.class);
        ArgumentCaptor<LocalDateTime> captorUntil = ArgumentCaptor.forClass(LocalDateTime.class);
        verify(weatherBasicRepository, times(1))
                .findByDateTimeBetween(captorFrom.capture(), captorUntil.capture());
        LocalDateTime from = captorFrom.getValue();
        LocalDateTime until = captorUntil.getValue();

        LocalDateTime dateTime = LocalDateTime.now();
        assertEquals(dateTime.getYear(), from.getYear());
        assertEquals(dateTime.getMonthValue(), from.getMonthValue());
        assertEquals(dateTime.getDayOfMonth(), from.getDayOfMonth());
        assertEquals(dateTime.getHour(), from.getHour());

        dateTime = dateTime.plusHours(period);
        assertEquals(dateTime.getYear(), until.getYear());
        assertEquals(dateTime.getMonthValue(), until.getMonthValue());
        assertEquals(dateTime.getDayOfMonth(), until.getDayOfMonth());
        assertEquals(dateTime.getHour(), until.getHour());
    }
}