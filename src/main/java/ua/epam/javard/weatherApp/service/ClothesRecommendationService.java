package ua.epam.javard.weatherApp.service;

import java.time.LocalDateTime;
import java.util.List;

public interface ClothesRecommendationService {

    List<String> getRecommendationForDateTime(LocalDateTime dateTime);
}
