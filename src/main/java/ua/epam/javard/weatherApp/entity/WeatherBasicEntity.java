package ua.epam.javard.weatherApp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_basic")
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class WeatherBasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "temp_celsius")
    private Double tempCelsius;

    @Column(name = "temp_feels_like_celsius")
    private Double tempFeelsLikeCelsius;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_details_id")
    private WeatherDetailsEntity weatherDetailsEntity;

    public WeatherBasicEntity() {
    }
}
