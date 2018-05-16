package ua.epam.javard.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.epam.javard.weatherApp.service.ClothesRecommendationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/clothes/recommendation")
public class ClothesRecommendationController {

    private ClothesRecommendationService clothesRecommendationService;

    @Autowired
    public ClothesRecommendationController(ClothesRecommendationService clothesRecommendationService) {
        this.clothesRecommendationService = clothesRecommendationService;
    }

    @RequestMapping("/today")
    public List<String> getClothesRecommendationForToday() {
        LocalTime time = LocalTime.of(LocalTime.now().plusHours(1).getHour(), 0);
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), time);
        return clothesRecommendationService.getRecommendationForDateTime(dateTime);
    }

    @RequestMapping("/tomorrow")
    public List<String> getClothesRecommendationForTomorrow() {
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(12, 0));
        return clothesRecommendationService.getRecommendationForDateTime(dateTime);
    }
}
