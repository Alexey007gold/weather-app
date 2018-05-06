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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Oleksii_Kovetskyi on 5/3/2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class WeatherBasicRepositoryITTest {

    @Autowired
    private WeatherBasicRepository weatherBasicRepository;
    private LocalDateTime[] dateTime;
    private WeatherDetailsEntity weatherDetailsEntity;

    @Before
    public void init() {
        weatherDetailsEntity = TestDataCreator.createWeatherDetailsEntity("icon",
                1111, "Rainy", "S", "South", 180L,
                10.5, 15.5, 90.0, 30L);

        WeatherBasicEntity weatherBasicEntity;
        dateTime = new LocalDateTime[] {LocalDateTime.of(2018, 10, 15, 5,  25),
                LocalDateTime.of(2018, 10, 16, 5,  25)};

        for (int i = 0; i < 2; i++) {
            weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(dateTime[i], 40.0 + i, 40.0);
            weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);
            weatherBasicRepository.save(weatherBasicEntity);
        }
    }

    @Test
    public void shouldReturnCorrectEntityOnFindByDateTime() {
        WeatherBasicEntity result1 = weatherBasicRepository.findByDateTime(dateTime[0]);
        WeatherBasicEntity result2 = weatherBasicRepository.findByDateTime(dateTime[1]);

        assertEquals(40.0, result1.getTempCelsius(), 0.0000001);
        assertEquals(41.0, result2.getTempCelsius(), 0.0000001);
    }

    @Test
    public void shouldReturnCorrectListOfEntitiesOnFindByDateTimeBetween() {
        putDataToRepo();

        //query for a specified range of dates
        LocalDateTime from = LocalDateTime.of(2018, 10, 10, 5,  25);
        LocalDateTime until = LocalDateTime.of(2018, 10, 20, 8,  45);
        List<WeatherBasicEntity> result = weatherBasicRepository.findByDateTimeBetween(from, until);

        for (WeatherBasicEntity weatherBasicEntity : result) {
            assertTrue(weatherBasicEntity.getDateTime().isAfter(from) ||
                    weatherBasicEntity.getDateTime().isEqual(from));
            assertTrue(weatherBasicEntity.getDateTime().isBefore(until) ||
                    weatherBasicEntity.getDateTime().isEqual(from));
        }
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldThrowAnExceptionOnSaveWhenThereIsAlreadyARowWithSuchDateTime() {
        WeatherBasicEntity weatherBasicEntity = createWeatherBasicEntity(dateTime[0]);
        weatherBasicRepository.saveAndFlush(weatherBasicEntity);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldDeleteRightRowsOnDeleteByDateTimeBetween() {
        putDataToRepo();

        LocalDateTime from = LocalDateTime.of(2018, 10, 10, 5,  25);
        LocalDateTime until = LocalDateTime.of(2018, 10, 20, 8,  45);

        //put corner values
        weatherBasicRepository.save(createWeatherBasicEntity(from));
        weatherBasicRepository.save(createWeatherBasicEntity(until));


        weatherBasicRepository.deleteByDateTimeBetween(from, until);

        List<WeatherBasicEntity> result = weatherBasicRepository.findAll();

        for (WeatherBasicEntity entry : result) {
            assertTrue(entry.getDateTime().isBefore(from));
            assertTrue(entry.getDateTime().isAfter(until));

            if (entry.getDateTime().isEqual(from)) {
                fail();
            }
        }
    }

    private void putDataToRepo() {
        //put some data to the repository
        Random random = new Random(999999999999999999L);
        Map<LocalDateTime, WeatherBasicEntity> entities = new HashMap<>();
        for (int i = 0; i < 200; i++) {
            LocalDateTime dateTime = LocalDateTime.of(2018, 10, random.nextInt(30) + 1,
                    random.nextInt(24),  random.nextInt(60));
            WeatherBasicEntity weatherBasicEntity = createWeatherBasicEntity(dateTime);
            entities.put(dateTime, weatherBasicEntity);
        }
        weatherBasicRepository.saveAll(entities.values());
        weatherBasicRepository.flush();
    }

    private WeatherBasicEntity createWeatherBasicEntity(LocalDateTime dateTime) {
        WeatherBasicEntity weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(dateTime, 40.0, 40.0);
        weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);
        return weatherBasicEntity;
    }
}