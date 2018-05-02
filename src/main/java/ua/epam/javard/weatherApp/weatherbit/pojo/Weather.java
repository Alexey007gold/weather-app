
package ua.epam.javard.weatherApp.weatherbit.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "icon",
    "code",
    "description"
})
@EqualsAndHashCode
@ToString
public class Weather {

    @JsonProperty("icon")
    private String icon;
    @JsonProperty("code")
    private long code;
    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("code")
    public long getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(long code) {
        this.code = code;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

}
