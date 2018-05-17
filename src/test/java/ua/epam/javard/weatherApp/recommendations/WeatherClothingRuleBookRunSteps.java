package ua.epam.javard.weatherApp.recommendations;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class WeatherClothingRuleBookRunSteps {

    private WeatherClothingRuleBook ruleBook;
    private WeatherClothingRecommendation recommendation;

    @Given("^I have weather clothing rule book that has neutral temperature lower bound (\\d+) and upper bound (\\d+)$")
    public void initRuleBook(int neutralTempLowerBound, int neutralTempUpperBound) throws Throwable {
        this.ruleBook = new WeatherClothingRuleBook(neutralTempUpperBound, neutralTempLowerBound);

    }

    @When("^Weather rule book defines clothes for fact with code (\\d+) and temperature (.+)$")
    public void defineRecommendedClothing(int code, double temperature) throws Throwable {
        WeatherFact weatherFact = new WeatherFact(code, temperature);
        NameValueReferableMap factMap = new FactMap();
        factMap.setValue("weatherFact", weatherFact);

        ruleBook.run(factMap);
        this.recommendation = ruleBook.getResult().orElseThrow(IllegalArgumentException::new).getValue();
    }

    @Then("^Expect that clothes list contains \"([^\"]*)\"$")
    public void verifyClothingMatch(String clothes) throws Throwable {
        List<Clothing> expectedClothing = Arrays.stream(clothes.split(", "))
                .map(String::trim)
                .map(Clothing::fromString).collect(Collectors.toList());
        assertEquals(expectedClothing, recommendation.getRecommendedClothing());
    }
}
