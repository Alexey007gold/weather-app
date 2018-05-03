package ua.epam.javard.weatherApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;

/**
 * Created by Oleksii_Kovetskyi on 5/2/2018.
 */
@Repository
public interface WeatherDetailsRepository extends JpaRepository<WeatherDetailsEntity, Long> {
}
