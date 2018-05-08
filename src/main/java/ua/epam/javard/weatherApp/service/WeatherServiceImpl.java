package ua.epam.javard.weatherApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.repository.WeatherBasicRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Oleksii_Kovetskyi on 5/3/2018.
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherBasicRepository weatherBasicRepository;

    @Autowired
    public WeatherServiceImpl(WeatherBasicRepository weatherBasicRepository) {
        this.weatherBasicRepository = weatherBasicRepository;
    }

    @Override
    public List<WeatherBasicEntity> getWeatherForDate(LocalDate date) {
        LocalDateTime from = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime until = LocalDateTime.of(date, LocalTime.MAX);
        return weatherBasicRepository.findByDateTimeBetween(from, until);
    }

    @Override
    public List<WeatherBasicEntity> getWeatherForecast(Period period) {
        return getWeatherForecast(period.getHours());
    }

    @Override
    public List<WeatherBasicEntity> getWeatherForecast(int hours) {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime until = from.plusHours(hours);
        return weatherBasicRepository.findByDateTimeBetween(from, until);
    }

}
