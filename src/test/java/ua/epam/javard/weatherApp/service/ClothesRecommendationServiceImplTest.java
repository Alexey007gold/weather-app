package ua.epam.javard.weatherApp.service;

import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.Result;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import ua.epam.javard.weatherApp.TestDataCreator;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;
import ua.epam.javard.weatherApp.recommendations.Clothing;
import ua.epam.javard.weatherApp.recommendations.WeatherClothingRecommendation;
import ua.epam.javard.weatherApp.recommendations.WeatherClothingRuleBook;
import ua.epam.javard.weatherApp.recommendations.WeatherFact;
import ua.epam.javard.weatherApp.repository.WeatherBasicRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ClothesRecommendationServiceImplTest {

    private ClothesRecommendationServiceImpl clothesRecommendationService;
    private WeatherBasicRepository weatherBasicRepository;
    private WeatherClothingRuleBook ruleBook;

    @Before
    public void init() {
        weatherBasicRepository = mock(WeatherBasicRepository.class);
        ruleBook = mock(WeatherClothingRuleBook.class);
        clothesRecommendationService = new ClothesRecommendationServiceImpl(weatherBasicRepository, () -> mock(WeatherClothingRuleBook.class));
    }

    @Test
    public void shouldCallServicesAndReturnCorrectListOfStringsOnGetRecommendationForDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        WeatherBasicEntity weatherBasicEntity = TestDataCreator.createWeatherBasicEntity(dateTime, 15.0, 17.0);
        WeatherDetailsEntity weatherDetailsEntity = TestDataCreator.createWeatherDetailsEntity(null,
                1111, null, null, null, 0L,
                0.0, 0.0, 0.0, 0L);
        weatherBasicEntity.setWeatherDetailsEntity(weatherDetailsEntity);

        WeatherClothingRecommendation recommendation = new WeatherClothingRecommendation();
        recommendation.addRecommendations(Clothing.PANAMA_HAT, Clothing.T_SHIRT, Clothing.LIGHT_PANTS, Clothing.BOOTS);

        when(weatherBasicRepository.findByDateTime(dateTime)).thenReturn(weatherBasicEntity);
        when(ruleBook.getResult()).thenReturn(Optional.of(new Result<>(recommendation)));


        List<String> result = clothesRecommendationService.getRecommendationForDateTime(dateTime);

        ArgumentCaptor<NameValueReferableMap> captor = ArgumentCaptor.forClass(NameValueReferableMap.class);

        verify(weatherBasicRepository, times(1)).findByDateTime(dateTime);
        verify(ruleBook, times(1)).run(captor.capture());

        //check rule book was run with correct fact
        WeatherFact fact = (WeatherFact) captor.getValue().getOne();
        assertEquals(1111, fact.getCode());
        assertEquals(15.0, fact.getTemperature(), 0.000000001);

        //check recommendation strings were generated correctly
        List<Clothing> recommendedClothing = recommendation.getRecommendedClothing();
        assertEquals(recommendedClothing.size(), result.size());
        for (int i = 0; i < recommendedClothing.size(); i++) {
            String expectedStr = String.format(ClothesRecommendationServiceImpl.CLOTHING_RECOMMENDATION_PATTERN,
                    recommendedClothing.get(i).getName());
            assertEquals(expectedStr, result.get(i));
        }
    }
}