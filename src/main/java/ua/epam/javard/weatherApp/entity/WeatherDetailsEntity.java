package ua.epam.javard.weatherApp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "weather_details")
@EqualsAndHashCode
@ToString(exclude = {"weatherBasicEntity"})
@Getter
@Setter
public class WeatherDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "weatherDetailsEntity")
    private WeatherBasicEntity weatherBasicEntity;

    @Column(name = "weather_icon_code")
    private String weatherIconCode;

    @Column(name = "weather_code")
    private Integer weatherCode;

    @Column(name = "weather_description")
    private String weatherDescription;

    @Column(name = "weather_dir_abbr")
    private String weatherDirAbbr;

    @Column(name = "weather_dir_full")
    private String weatherDirFull;

    @Column(name = "weather_dir_degrees")
    private Double weatherDirDegrees;

    @Column(name = "wind_speed")
    private Double windSpeed;

    @Column(name = "wind_gust_speed")
    private Double windGustSpeed;

    @Column(name = "pressure")
    private Double pressure;

    @Column(name = "humidity")
    private Double humidity;

    public WeatherDetailsEntity() {
    }
}
