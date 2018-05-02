CREATE TABLE weather_details
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    weather_icon_code VARCHAR(10) NOT NULL,
    weather_code INT NOT NULL,
    weather_description VARCHAR(50) NOT NULL,
    wind_dir_abbr VARCHAR(5) NOT NULL,
    wind_dir_full VARCHAR(50) NOT NULL,
    wind_dir_degrees DOUBLE PRECISION NOT NULL,
    wind_speed DOUBLE PRECISION NOT NULL,
    wind_gust_speed DOUBLE PRECISION NOT NULL,
    pressure DOUBLE PRECISION NOT NULL,
    humidity DOUBLE PRECISION NOT NULL
);
CREATE UNIQUE INDEX weather_details_id_uindex ON weather_details (id);

CREATE TABLE weather_basic
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    weather_details_id BIGINT NOT NULL,
    city_id BIGINT NOT NULL,
    date_time TIMESTAMP NOT NULL,
    temp_celsius DOUBLE PRECISION NOT NULL,
    temp_feels_like_celsius DOUBLE PRECISION NOT NULL,

    CONSTRAINT weather_basic_weather_details_id_fk FOREIGN KEY (weather_details_id) REFERENCES weather_details (id)
);
CREATE UNIQUE INDEX weather_basic_id_uindex ON weather_basic (id);
CREATE UNIQUE INDEX weather_basic_weather_details_id_uindex ON weather_basic (weather_details_id);