package ua.epam.javard.weatherApp.recommendations;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WeatherClothingRecommendation<T extends Clothing> {

    private List<T> recommendedClothing = new ArrayList<>();

    public void addRecommendation(T clothing) {
        recommendedClothing.add(clothing);
    }
}
