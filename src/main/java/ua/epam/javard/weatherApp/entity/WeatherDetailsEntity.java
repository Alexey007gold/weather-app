package ua.epam.javard.weatherApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "weather_details")
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"weatherBasicEntity"})
@Getter
@Setter
public class WeatherDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "weatherDetailsEntity")
    @JoinColumn(nullable = false)
    private WeatherBasicEntity weatherBasicEntity;

    @Column(name = "weather_icon_code", nullable = false)
    private String weatherIconCode;

    @Column(name = "weather_code", nullable = false)
    private Integer weatherCode;

    @Column(name = "weather_description", nullable = false)
    private String weatherDescription;

    @Column(name = "weather_dir_abbr", nullable = false)
    private String weatherDirAbbr;

    @Column(name = "weather_dir_full", nullable = false)
    private String weatherDirFull;

    @Column(name = "weather_dir_degrees", nullable = false)
    private Double weatherDirDegrees;

    @Column(name = "wind_speed", nullable = false)
    private Double windSpeed;

    @Column(name = "wind_gust_speed", nullable = false)
    private Double windGustSpeed;

    @Column(name = "pressure", nullable = false)
    private Double pressure;

    @Column(name = "humidity", nullable = false)
    private Double humidity;

}
