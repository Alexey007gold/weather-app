package ua.epam.javard.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.epam.javard.weatherApp.common.Unit;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.service.WeatherService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Oleksii_Kovetskyi on 5/5/2018.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private static final String DEFAULT_UNIT = "METRIC";
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/today")
    public List<WeatherBasicEntity> getWeatherForToday(@RequestParam(defaultValue = DEFAULT_UNIT) Unit unit) {
        return getWeatherForDate(unit, LocalDate.now());
    }

    @RequestMapping("/tomorrow")
    public List<WeatherBasicEntity> getWeatherForTomorrow(@RequestParam(defaultValue = DEFAULT_UNIT) Unit unit) {
        return getWeatherForDate(unit, LocalDate.now().plusDays(1));
    }

    private List<WeatherBasicEntity> getWeatherForDate(Unit unit, LocalDate date) {
        switch (unit) {
            case METRIC:
                return weatherService.getWeatherForDate(date);
            default:
                throw new UnsupportedOperationException(String.format("Unit %s is not supported yet", unit));
        }
    }
}
