package ua.epam.javard.weatherApp.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.epam.javard.weatherApp.TestDataCreator;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Oleksii_Kovetskyi on 5/2/2018.
 *
 * Tests One To One relation between
 * WeatherBasicRepository and WeatherDetailsRepository
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class WeatherBasicWeatherDetailsRepositoriesITTest {

    @Autowired
    private WeatherBasicRepository weatherBasicRepository;
    @Autowired
    private WeatherDetailsRepository weatherDetailsRepository;

    private LocalDateTime dateTime;

    @Before
    public void init() {
        dateTime = LocalDateTime.of(2018, 10, 20, 13, 0);

        WeatherDetailsEntity weatherDetailsEntity = TestDataCreator.createWeatherDetailsEntity("icon",
                1111, "Rainy", "S", "South", 180L,
                10.5, 15.5, 90.0, 30L);

        WeatherBasicEntity weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(dateTime, 40.0, 40.0);

        weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);
        weatherDetailsEntity.setWeatherBasicEntity(weatherBasicEntity);

        weatherBasicRepository.save(weatherBasicEntity);
    }

    @Test
    public void shouldDeleteBothEntitiesOnWeatherBasicDelete() {
        WeatherBasicEntity basic = weatherBasicRepository.findByDateTime(dateTime);
        weatherBasicRepository.delete(basic);

        basic = weatherBasicRepository.findByDateTime(dateTime);

        assertNull(basic);
        assertEquals(0, weatherDetailsRepository.count());
    }

    @Test
    public void shouldDeleteBothEntitiesOnWeatherDetailsDelete() {
        WeatherBasicEntity basic = weatherBasicRepository.findByDateTime(dateTime);
        weatherDetailsRepository.delete(basic.getWeatherDetailsEntity());

        basic = weatherBasicRepository.findByDateTime(dateTime);

        assertNull(basic);
        assertEquals(0, weatherDetailsRepository.count());
    }

    @Test
    public void shouldUpdateBothEntitiesOnWeatherBasicUpdate() {
        WeatherBasicEntity basic = weatherBasicRepository.findByDateTime(dateTime);
        basic.setTempCelsius(50.0);
        basic.getWeatherDetailsEntity().setWeatherDescription("Sunny");
        weatherBasicRepository.save(basic);

        basic = weatherBasicRepository.findByDateTime(dateTime);

        assertEquals(50.0, basic.getWeatherDetailsEntity().getWeatherBasicEntity().getTempCelsius(), 0.00000001);
        assertEquals("Sunny", basic.getWeatherDetailsEntity().getWeatherDescription());
    }

    @Test
    public void shouldUpdateBothEntitiesOnWeatherDetailsUpdate() {
        WeatherBasicEntity basic = weatherBasicRepository.findByDateTime(dateTime);
        basic.setTempCelsius(50.0);
        basic.getWeatherDetailsEntity().setWeatherDescription("Sunny");
        weatherDetailsRepository.save(basic.getWeatherDetailsEntity());

        basic = weatherBasicRepository.findByDateTime(dateTime);

        assertEquals(50.0, basic.getWeatherDetailsEntity().getWeatherBasicEntity().getTempCelsius(), 0.00000001);
        assertEquals("Sunny", basic.getWeatherDetailsEntity().getWeatherDescription());
    }

}