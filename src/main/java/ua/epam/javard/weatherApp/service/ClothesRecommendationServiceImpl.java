package ua.epam.javard.weatherApp.service;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.entity.WeatherDetailsEntity;
import ua.epam.javard.weatherApp.recommendations.Clothing;
import ua.epam.javard.weatherApp.recommendations.WeatherClothingRecommendation;
import ua.epam.javard.weatherApp.recommendations.WeatherFact;
import ua.epam.javard.weatherApp.repository.WeatherBasicRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClothesRecommendationServiceImpl implements ClothesRecommendationService {

    private static final String WEATHER_FACT_KEY = "weatherFact";
    public static final String CLOTHING_RECOMMENDATION_PATTERN = "Take %s";

    private WeatherBasicRepository weatherBasicRepository;
    private ObjectFactory<RuleBook<WeatherClothingRecommendation>> ruleBookObjectFactory;

    @Autowired
    public ClothesRecommendationServiceImpl(WeatherBasicRepository weatherBasicRepository,
                                            ObjectFactory<RuleBook<WeatherClothingRecommendation>> ruleBookObjectFactory) {
        this.weatherBasicRepository = weatherBasicRepository;
        this.ruleBookObjectFactory = ruleBookObjectFactory;
    }

    @Override
    public List<String> getRecommendationForDateTime(LocalDateTime dateTime) {
        WeatherBasicEntity weatherBasicEntity = weatherBasicRepository.findByDateTime(dateTime);
        if (weatherBasicEntity == null) {
            throw new IllegalArgumentException("Information for the given date was not found");
        }

        NameValueReferableMap<WeatherFact> factMap = fillWeatherFactMap(weatherBasicEntity);
        RuleBook<WeatherClothingRecommendation> ruleBook = ruleBookObjectFactory.getObject();
        ruleBook.run(factMap);

        Optional<Result<WeatherClothingRecommendation>> result = ruleBook.getResult();
        if (result.isPresent()) {
            WeatherClothingRecommendation recommendation = result.get().getValue();
            return getStringRecommendations(recommendation);
        } else {
            return Collections.emptyList();
        }
    }

    private NameValueReferableMap<WeatherFact> fillWeatherFactMap(WeatherBasicEntity weatherBasicEntity) {
        WeatherDetailsEntity weatherDetailsEntity = weatherBasicEntity.getWeatherDetailsEntity();

        WeatherFact weatherFact = new WeatherFact();
        weatherFact.setTemperature(weatherBasicEntity.getTempCelsius());
        weatherFact.setCode(weatherDetailsEntity.getWeatherCode());

        NameValueReferableMap<WeatherFact> factMap = new FactMap<>();
        factMap.setValue(WEATHER_FACT_KEY, weatherFact);
        return factMap;
    }

    private List<String> getStringRecommendations(WeatherClothingRecommendation recommendation) {
        List<String> recommendationList = new ArrayList<>();
        for (Clothing clothing : recommendation.getRecommendedClothing()) {
            recommendationList.add(String.format(CLOTHING_RECOMMENDATION_PATTERN, clothing.getName()));
        }
        return recommendationList;
    }
}
