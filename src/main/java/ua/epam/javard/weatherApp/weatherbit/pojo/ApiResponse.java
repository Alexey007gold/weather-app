
package ua.epam.javard.weatherApp.weatherbit.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "city_name",
    "lon",
    "timezone",
    "lat",
    "country_code",
    "state_code"
})
public class ApiResponse {

    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("lon")
    private String longitude;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("state_code")
    private String stateCode;

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city_name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("lon")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("lon")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("lat")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("lat")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    @JsonProperty("state_code")
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }


}
