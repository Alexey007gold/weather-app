package test;

import com.deliveredtechnologies.rulebook.NameValueReferableTypeConvertibleMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class WeatherClothingRuleBook extends CoRRuleBook<WeatherClothingRecommendation> {

    private int neutralTempUpperBound;

    private int neutralTempLowerBound;

    public WeatherClothingRuleBook(int neutralTempUpperBound, int neutralTempLowerBound) {
        this.neutralTempUpperBound = neutralTempUpperBound;
        this.neutralTempLowerBound = neutralTempLowerBound;
    }

    @Override
    public void defineRules() {
        addWeatherRule(facts -> facts.getOne().is200x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is200x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is200x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {});

        addWeatherRule(facts -> facts.getOne().is300x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is300x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is300x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {});

        addWeatherRule(facts -> facts.getOne().is400x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is400x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is400x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {});

        addWeatherRule(facts -> facts.getOne().is500x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is500x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is500x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {});

        addWeatherRule(facts -> facts.getOne().is600x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is600x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is600x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {});

        addWeatherRule(facts -> facts.getOne().is700x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is700x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is700x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {});

        addWeatherRule(facts -> facts.getOne().is800x() && facts.getOne().isCold(neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is800x() && facts.getOne().isNeutral(neutralTempUpperBound, neutralTempLowerBound), (facts, result) -> {});
        addWeatherRule(facts -> facts.getOne().is800x() && facts.getOne().isHot(neutralTempUpperBound), (facts, result) -> {});
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


}
