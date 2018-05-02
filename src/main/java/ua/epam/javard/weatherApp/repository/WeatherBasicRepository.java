package ua.epam.javard.weatherApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Oleksii_Kovetskyi on 5/2/2018.
 */
@Repository
public interface WeatherBasicRepository extends JpaRepository<WeatherBasicEntity, Long> {
    WeatherBasicEntity findByCityIdAndDateTime(Long city_id, LocalDateTime dateTime);
    List<WeatherBasicEntity> findByDateTime(LocalDateTime dateTime);
}
