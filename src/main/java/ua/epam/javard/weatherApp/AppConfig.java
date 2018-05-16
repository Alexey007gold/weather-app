package ua.epam.javard.weatherApp;

import com.deliveredtechnologies.rulebook.model.RuleBook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import ua.epam.javard.weatherApp.recommendations.WeatherClothingRuleBook;

@Configuration
@EnableScheduling
@PropertySource("classpath:weatherbit_api.properties")
public class AppConfig {

    @Value("${temperature.neutral.upper}")
    private int neutralTempUpperBound;
    @Value("${temperature.neutral.lower}")
    private int neutralTempLowerBound;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "weatherClothingRuleBook")
    @Scope("prototype")
    public RuleBook book() {
        return new WeatherClothingRuleBook(neutralTempUpperBound, neutralTempLowerBound);
    }
}

