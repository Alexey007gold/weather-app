package ua.epam.javard.weatherApp.recommendations;

import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.NameValueReferableTypeConvertibleMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static ua.epam.javard.weatherApp.recommendations.Clothing.*;

public class WeatherClothingRuleBook extends CoRRuleBook<WeatherClothingRecommendation> {

    private int neutralTempUpperBound;

    private int neutralTempLowerBound;

    public WeatherClothingRuleBook(int neutralTempUpperBound, int neutralTempLowerBound) {
        this.neutralTempUpperBound = neutralTempUpperBound;
        this.neutralTempLowerBound = neutralTempLowerBound;
        this.setDefaultResult(new WeatherClothingRecommendation());
    }

    @Override
    public void defineRules() {
        addWeatherRule(facts -> facts.getOne().is200x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, WARM_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is200x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, LIGHT_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is200x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, LIGHT_PANTS, BOOTS);
        });

        addWeatherRule(facts -> facts.getOne().is300x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, WARM_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is300x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, LIGHT_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is300x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, LIGHT_PANTS, BOOTS);
        });

        addWeatherRule(facts -> facts.getOne().is500x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, BEANIE, WINTER_JACKET, WARM_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is500x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, LIGHT_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is500x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {
            result.getValue().addRecommendations(UMBRELLA, JACKET, LIGHT_PANTS, BOOTS);
        });

        addWeatherRule(facts -> facts.getOne().is600x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(BEANIE, SCARF, WINTER_JACKET, WARM_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is600x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(SCARF, JACKET, WARM_PANTS, BOOTS);
        });

        addWeatherRule(facts -> facts.getOne().is700x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(BEANIE, SCARF, WINTER_JACKET, WARM_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is700x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(SCARF, JACKET, WARM_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is700x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {
            result.getValue().addRecommendations(PANAMA_HAT, SUNGLASSES, T_SHIRT, SHORTS, SNEAKERS);
        });

        addWeatherRule(facts -> facts.getOne().is800x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(BEANIE, SCARF, WINTER_JACKET, WARM_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is800x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {
            result.getValue().addRecommendations(SCARF, JACKET, LIGHT_PANTS, BOOTS);
        });
        addWeatherRule(facts -> facts.getOne().is800x() && facts.getOne().isHot(neutralTempUpperBound),
                (facts, result) -> result.getValue().addRecommendations(BASEBALL_HAT, SUNGLASSES, T_SHIRT, SHORTS, SANDALS));
    }


    private void addWeatherRule(Predicate<NameValueReferableTypeConvertibleMap<WeatherFact>> condition,
                                BiConsumer<NameValueReferableTypeConvertibleMap<WeatherFact>, Result<WeatherClothingRecommendation>> action) {
        addRule(RuleBuilder.create()
                .withFactType(WeatherFact.class)
                .withResultType(WeatherClothingRecommendation.class)
                .when(condition)
                .then(action)
                .build());
    }

    @Override
    public void run(NameValueReferableMap facts) {
        setDefaultResult(new WeatherClothingRecommendation());
        super.run(facts);
    }
}
