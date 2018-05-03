package ua.epam.javard.weatherApp.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import ua.epam.javard.weatherApp.TestDataCreator;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Oleksii_Kovetskyi on 5/3/2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class WeatherBasicRepositoryITTest {

    @Autowired
    private WeatherBasicRepository weatherBasicRepository;
    private LocalDateTime dateTime;
    private WeatherDetailsEntity weatherDetailsEntity;

    @Before
    public void init() {
        weatherDetailsEntity = TestDataCreator.createWeatherDetailsEntity("icon",
                1111, "Rainy", "S", "South", 180.0,
                10.5, 15.5, 90.0, 30.0);

        WeatherBasicEntity weatherBasicEntity;
        dateTime = LocalDateTime.of(2018, 10, 15, 5,  25);

        for (long i = 0; i < 4; i++) {
            weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(i, dateTime, 40.0, 40.0);
            weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);
            weatherBasicRepository.save(weatherBasicEntity);
        }
    }

    @Test
    public void shouldReturnCorrectListOfEntitiesOnFindByCityIdAndDateTime() {
        WeatherBasicEntity result = weatherBasicRepository.findByCityIdAndDateTime(1L, dateTime);

        assertTrue(result.getDateTime().isEqual(dateTime));
    }

    @Test
    public void shouldReturnCorrectListOfEntitiesOnFindByCityIdAndDateTimeBetween() {
        //put some data to the repository
        Random random = new Random(999999999999999999L);
        List<WeatherBasicEntity> entities = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            LocalDateTime dateTime = LocalDateTime.of(2018, 10, random.nextInt(30) + 1,
                    random.nextInt(24),  random.nextInt(60));
            WeatherBasicEntity weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(1L, dateTime,
                    40.0, 40.0);
            weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);
            entities.add(weatherBasicEntity);
        }
        weatherBasicRepository.saveAll(entities);

        //query for a specified range of dates
        LocalDateTime from = LocalDateTime.of(2018, 10, 10, 5,  25);
        LocalDateTime until = LocalDateTime.of(2018, 10, 20, 8,  45);
        List<WeatherBasicEntity> result = weatherBasicRepository.findByCityIdAndDateTimeBetween(1L, from, until);

        for (WeatherBasicEntity weatherBasicEntity : result) {
            assertTrue(weatherBasicEntity.getDateTime().isAfter(from) ||
                    weatherBasicEntity.getDateTime().isEqual(from));
            assertTrue(weatherBasicEntity.getDateTime().isBefore(until) ||
                    weatherBasicEntity.getDateTime().isEqual(from));
            assertEquals(1L, (long) weatherBasicEntity.getCityId());
        }
    }

    @Test
    public void shouldReturnCorrectListOfEntitiesOnFindByDateTime() {
        List<WeatherBasicEntity> result = weatherBasicRepository.findByDateTime(dateTime);

        Set<Long> cityIds = result.stream()
                .mapToLong(WeatherBasicEntity::getCityId)
                .boxed()
                .collect(toSet());

        List<Long> expectedCityIds = Arrays.asList(0L, 1L, 2L, 3L);

        assertEquals(4, cityIds.size());
        assertTrue(cityIds.containsAll(expectedCityIds));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldThrowAnExceptionOnSave() {
        WeatherBasicEntity weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(3L, dateTime, 40.0, 40.0);
        weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);
        weatherBasicRepository.saveAndFlush(weatherBasicEntity);
    }
}