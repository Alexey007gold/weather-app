
package ua.epam.javard.weatherApp.weatherbit.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pod",
    "wind_cdir",
    "wind_cdir_full",
    "wind_dir",
    "rh",
    "wind_spd",
    "pop",
    "timestamp_utc",
    "wind_gust_spd",
    "slp",
    "snow_depth",
    "clouds_mid",
    "clouds_low",
    "pres",
    "dni",
    "dewpt",
    "snow",
    "uv",
    "clouds_hi",
    "ozone",
    "weather",
    "ghi",
    "precip",
    "timestamp_local",
    "ts",
    "app_temp",
    "datetime",
    "temp",
    "dhi",
    "clouds",
    "vis"
})
@EqualsAndHashCode
@ToString
public class Observation {

    @JsonProperty("pod")
    private String partOfTheDay;
    @JsonProperty("wind_cdir")
    private String windDirectionAbbreviation;
    @JsonProperty("wind_cdir_full")
    private String windDirection;
    @JsonProperty("wind_dir")
    private long windDirectionDegrees;
    @JsonProperty("rh")
    private long relativeHumidity;
    @JsonProperty("wind_spd")
    private double windSpeed;
    @JsonProperty("pop")
    private long chanceOfRain;
    @JsonProperty("timestamp_utc")
    private String timestampUtc;
    @JsonProperty("wind_gust_spd")
    private double windGustSpeed;
    @JsonProperty("slp")
    private double seaLevelPressure;
    @JsonProperty("snow_depth")
    private long snowDepth;
    @JsonProperty("clouds_mid")
    private long cloudsMidLevelCoverage;
    @JsonProperty("clouds_low")
    private long cloudsLowLevelCoverage;
    @JsonProperty("pres")
    private double pressure;
    @JsonProperty("dni")
    private double dni;
    @JsonProperty("dewpt")
    private double dewPoint;
    @JsonProperty("snow")
    private long snowfallLevel;
    @JsonProperty("uv")
    private double uvIndex;
    @JsonProperty("clouds_hi")
    private long cloudsHighLevelCoverage;
    @JsonProperty("ozone")
    private double averageOzon;
    @JsonProperty("weather")
    private Weather weather;
    @JsonProperty("ghi")
    private double ghi;
    @JsonProperty("precip")
    private long rainLevel;
    @JsonProperty("timestamp_local")
    private String timestampLocal;
    @JsonProperty("ts")
    private long timestamp;
    @JsonProperty("app_temp")
    private double apparentTemperature;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("temp")
    private double temperature;
    @JsonProperty("dhi")
    private double dhi;
    @JsonProperty("clouds")
    private long cloudsCoverage;
    @JsonProperty("vis")
    private double visibility;


    @JsonProperty("pod")
    public String getPartOfTheDay() {
        return partOfTheDay;
    }

    @JsonProperty("pod")
    public void setPartOfTheDay(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }

    @JsonProperty("wind_cdir")
    public String getWindDirectionAbbreviation() {
        return windDirectionAbbreviation;
    }

    @JsonProperty("wind_cdir")
    public void setWindDirectionAbbreviation(String windDirectionAbbreviation) {
        this.windDirectionAbbreviation = windDirectionAbbreviation;
    }

    @JsonProperty("wind_cdir_full")
    public String getWindDirection() {
        return windDirection;
    }

    @JsonProperty("wind_cdir_full")
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    @JsonProperty("wind_dir")
    public long getWindDirectionDegrees() {
        return windDirectionDegrees;
    }

    @JsonProperty("wind_dir")
    public void setWindDirectionDegrees(long windDirectionDegrees) {
        this.windDirectionDegrees = windDirectionDegrees;
    }

    @JsonProperty("rh")
    public long getRelativeHumidity() {
        return relativeHumidity;
    }

    @JsonProperty("rh")
    public void setRelativeHumidity(long relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    @JsonProperty("wind_spd")
    public double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wind_spd")
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("pop")
    public long getChanceOfRain() {
        return chanceOfRain;
    }

    @JsonProperty("pop")
    public void setChanceOfRain(long chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    @JsonProperty("timestamp_utc")
    public String getTimestampUtc() {
        return timestampUtc;
    }

    @JsonProperty("timestamp_utc")
    public void setTimestampUtc(String timestampUtc) {
        this.timestampUtc = timestampUtc;
    }

    @JsonProperty("wind_gust_spd")
    public double getWindGustSpeed() {
        return windGustSpeed;
    }

    @JsonProperty("wind_gust_spd")
    public void setWindGustSpeed(double windGustSpeed) {
        this.windGustSpeed = windGustSpeed;
    }

    @JsonProperty("slp")
    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    @JsonProperty("slp")
    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    @JsonProperty("snow_depth")
    public long getSnowDepth() {
        return snowDepth;
    }

    @JsonProperty("snow_depth")
    public void setSnowDepth(long snowDepth) {
        this.snowDepth = snowDepth;
    }

    @JsonProperty("clouds_mid")
    public long getCloudsMidLevelCoverage() {
        return cloudsMidLevelCoverage;
    }

    @JsonProperty("clouds_mid")
    public void setCloudsMidLevelCoverage(long cloudsMidLevelCoverage) {
        this.cloudsMidLevelCoverage = cloudsMidLevelCoverage;
    }

    @JsonProperty("clouds_low")
    public long getCloudsLowLevelCoverage() {
        return cloudsLowLevelCoverage;
    }

    @JsonProperty("clouds_low")
    public void setCloudsLowLevelCoverage(long cloudsLowLevelCoverage) {
        this.cloudsLowLevelCoverage = cloudsLowLevelCoverage;
    }

    @JsonProperty("pres")
    public double getPressure() {
        return pressure;
    }

    @JsonProperty("pres")
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("dni")
    public double getDni() {
        return dni;
    }

    @JsonProperty("dni")
    public void setDni(double dni) {
        this.dni = dni;
    }

    @JsonProperty("dewpt")
    public double getDewPoint() {
        return dewPoint;
    }

    @JsonProperty("dewpt")
    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    @JsonProperty("snow")
    public long getSnowfallLevel() {
        return snowfallLevel;
    }

    @JsonProperty("snow")
    public void setSnowfallLevel(long snowfallLevel) {
        this.snowfallLevel = snowfallLevel;
    }

    @JsonProperty("uv")
    public double getUvIndex() {
        return uvIndex;
    }

    @JsonProperty("uv")
    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    @JsonProperty("clouds_hi")
    public long getCloudsHighLevelCoverage() {
        return cloudsHighLevelCoverage;
    }

    @JsonProperty("clouds_hi")
    public void setCloudsHighLevelCoverage(long cloudsHighLevelCoverage) {
        this.cloudsHighLevelCoverage = cloudsHighLevelCoverage;
    }

    @JsonProperty("ozone")
    public double getAverageOzon() {
        return averageOzon;
    }

    @JsonProperty("ozone")
    public void setAverageOzon(double averageOzon) {
        this.averageOzon = averageOzon;
    }

    @JsonProperty("weather")
    public Weather getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @JsonProperty("ghi")
    public double getGhi() {
        return ghi;
    }

    @JsonProperty("ghi")
    public void setGhi(double ghi) {
        this.ghi = ghi;
    }

    @JsonProperty("precip")
    public long getRainLevel() {
        return rainLevel;
    }

    @JsonProperty("precip")
    public void setRainLevel(long rainLevel) {
        this.rainLevel = rainLevel;
    }

    @JsonProperty("timestamp_local")
    public String getTimestampLocal() {
        return timestampLocal;
    }

    @JsonProperty("timestamp_local")
    public void setTimestampLocal(String timestampLocal) {
        this.timestampLocal = timestampLocal;
    }

    @JsonProperty("ts")
    public long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("ts")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("app_temp")
    public double getApparentTemperature() {
        return apparentTemperature;
    }

    @JsonProperty("app_temp")
    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    @JsonProperty("datetime")
    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @JsonProperty("temp")
    public double getTemperature() {
        return temperature;
    }

    @JsonProperty("temp")
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("dhi")
    public double getDhi() {
        return dhi;
    }

    @JsonProperty("dhi")
    public void setDhi(double dhi) {
        this.dhi = dhi;
    }

    @JsonProperty("clouds")
    public long getCloudsCoverage() {
        return cloudsCoverage;
    }

    @JsonProperty("clouds")
    public void setCloudsCoverage(long cloudsCoverage) {
        this.cloudsCoverage = cloudsCoverage;
    }

    @JsonProperty("vis")
    public double getVisibility() {
        return visibility;
    }

    @JsonProperty("vis")
    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

}
