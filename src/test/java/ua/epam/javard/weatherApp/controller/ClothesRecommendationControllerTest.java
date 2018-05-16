package ua.epam.javard.weatherApp.controller;

import org.junit.Before;
import org.junit.Test;
import ua.epam.javard.weatherApp.service.ClothesRecommendationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ClothesRecommendationControllerTest {

    private ClothesRecommendationController clothesRecommendationController;
    private ClothesRecommendationService clothesRecommendationService;
    private List<String> recommendationList;

    @Before
    public void init() {
        clothesRecommendationService = mock(ClothesRecommendationService.class);
        clothesRecommendationController = new ClothesRecommendationController(clothesRecommendationService);

        recommendationList = new ArrayList<>();
        recommendationList.add("Some recommendation");
        recommendationList.add("Another recommendation");
    }

    @Test
    public void shouldCallServiceWithCorrectArgumentAndReturnItsResultOnGetClothesRecommendationForTodayCall() {
        LocalTime time = LocalTime.of(LocalTime.now().plusHours(1).getHour(), 0);
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), time);

        when(clothesRecommendationService.getRecommendationForDateTime(dateTime)).thenReturn(recommendationList);

        List<String> result = clothesRecommendationController.getClothesRecommendationForToday();

        verify(clothesRecommendationService, times(1)).getRecommendationForDateTime(dateTime);
        assertEquals(recommendationList, result);
    }

    @Test
    public void shouldCallServiceWithCorrectArgumentAndReturnItsResultOnGetClothesRecommendationForTomorrowCall() {
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(12, 0));

        when(clothesRecommendationService.getRecommendationForDateTime(dateTime)).thenReturn(recommendationList);

        List<String> result = clothesRecommendationController.getClothesRecommendationForTomorrow();

        verify(clothesRecommendationService, times(1)).getRecommendationForDateTime(dateTime);
        assertEquals(recommendationList, result);
    }
}