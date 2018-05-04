package ua.epam.javard.weatherApp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_basic", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"date_time"})
})
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class WeatherBasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "temp_celsius", nullable = false)
    private Double tempCelsius;

    @Column(name = "temp_feels_like_celsius", nullable = false)
    private Double tempFeelsLikeCelsius;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_details_id", nullable = false)
    private WeatherDetailsEntity weatherDetailsEntity;

}
