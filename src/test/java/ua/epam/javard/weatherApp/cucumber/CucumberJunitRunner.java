package ua.epam.javard.weatherApp.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:clothes_recommendations/stories.feature"},
        glue = "ua.epam.javard.weatherApp.recommendations")
public class CucumberJunitRunner {
}
