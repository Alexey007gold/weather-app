package ua.epam.javard.weatherApp.weatherbit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ua.epam.javard.weatherApp.entity.WeatherBasicEntity;
import ua.epam.javard.weatherApp.repository.WeatherBasicRepository;
import ua.epam.javard.weatherApp.weatherbit.pojo.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherApiClientServiceImpl implements WeatherApiClientService{

    private final WeatherBasicRepository weatherBasicRepository;
    private final RestTemplate restTemplate;

    @Value("${weatherbit.key}")
    private String key;

    @Value("${city.id}")
    private Integer cityId;

    @Value("${api.base.url}")
    private String baseUrlForTwoDays;

    @Autowired
    public WeatherApiClientServiceImpl(WeatherBasicRepository weatherBasicRepository, RestTemplate restTemplate) {
        this.weatherBasicRepository = weatherBasicRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    @Scheduled(fixedDelayString = "${update.delay}")
    @Transactional
    public void updateDbWithWeatherData() {
        ApiResponse response = getWeatherForTwoDays();
        List<WeatherBasicEntity> newDataList = ApiResponseConverter.fromApiResponse(response);
        weatherBasicRepository.deleteAllByDateTimeAfter(LocalDateTime.now().minusHours(3));
        weatherBasicRepository.saveAll(newDataList);
    }

    private ApiResponse getWeatherForTwoDays() {
        String url = baseUrlForTwoDays + "key=" + key + "&city_id=" + cityId;
        return restTemplate.getForObject(url, ApiResponse.class);
    }
}
