package test;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherFact {

    public long code;

    public double temperature;



    public boolean is200x() {
        return code >= 200 && code < 300;
    }

    public boolean is300x() {
        return code >= 300 && code < 400;
    }

    public boolean is500x() {
        return code >= 500 && code < 600;
    }

    public boolean is600x() {
        return code >= 600 && code < 700;
    }

    public boolean is700x() {
        return code >= 700 && code < 800;
    }

    public boolean is800x() {
        return code >= 800 && code < 900;
    }

    public boolean isNeutral(double neutralUpperBound, double neutralLowerBound) {
        return temperature > neutralLowerBound && temperature <= neutralUpperBound;
    }

    public boolean isHot(double neutralUpperBound) {
        return temperature > neutralUpperBound;
    }

    public boolean isCold(double neutralLowerBound) {
        return temperature < neutralLowerBound;
    }
}
