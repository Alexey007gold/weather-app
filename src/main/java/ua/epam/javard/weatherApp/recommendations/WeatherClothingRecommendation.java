package ua.epam.javard.weatherApp.recommendations;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WeatherClothingRecommendation {

    private List<Clothing> recommendedClothing = new ArrayList<>();

    public void addRecommendations(Clothing ...clothing) {
        recommendedClothing.addAll(Arrays.asList(clothing));
    }
}
