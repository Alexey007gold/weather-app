
package ua.epam.javard.weatherApp.weatherbit.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
public class Datum {

    @JsonProperty("pod")
    private String pod;
    @JsonProperty("wind_cdir")
    private String windCdir;
    @JsonProperty("wind_cdir_full")
    private String windCdirFull;
    @JsonProperty("wind_dir")
    private long windDir;
    @JsonProperty("rh")
    private long rh;
    @JsonProperty("wind_spd")
    private double windSpd;
    @JsonProperty("pop")
    private long pop;
    @JsonProperty("timestamp_utc")
    private String timestampUtc;
    @JsonProperty("wind_gust_spd")
    private double windGustSpd;
    @JsonProperty("slp")
    private double slp;
    @JsonProperty("snow_depth")
    private long snowDepth;
    @JsonProperty("clouds_mid")
    private long cloudsMid;
    @JsonProperty("clouds_low")
    private long cloudsLow;
    @JsonProperty("pres")
    private double pres;
    @JsonProperty("dni")
    private double dni;
    @JsonProperty("dewpt")
    private double dewpt;
    @JsonProperty("snow")
    private long snow;
    @JsonProperty("uv")
    private double uv;
    @JsonProperty("clouds_hi")
    private long cloudsHi;
    @JsonProperty("ozone")
    private double ozone;
    @JsonProperty("weather")
    private Weather weather;
    @JsonProperty("ghi")
    private double ghi;
    @JsonProperty("precip")
    private long precip;
    @JsonProperty("timestamp_local")
    private String timestampLocal;
    @JsonProperty("ts")
    private long ts;
    @JsonProperty("app_temp")
    private double appTemp;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("temp")
    private double temp;
    @JsonProperty("dhi")
    private double dhi;
    @JsonProperty("clouds")
    private long clouds;
    @JsonProperty("vis")
    private double vis;

    @JsonProperty("pod")
    public String getPod() {
        return pod;
    }

    @JsonProperty("pod")
    public void setPod(String pod) {
        this.pod = pod;
    }

    @JsonProperty("wind_cdir")
    public String getWindCdir() {
        return windCdir;
    }

    @JsonProperty("wind_cdir")
    public void setWindCdir(String windCdir) {
        this.windCdir = windCdir;
    }

    @JsonProperty("wind_cdir_full")
    public String getWindCdirFull() {
        return windCdirFull;
    }

    @JsonProperty("wind_cdir_full")
    public void setWindCdirFull(String windCdirFull) {
        this.windCdirFull = windCdirFull;
    }

    @JsonProperty("wind_dir")
    public long getWindDir() {
        return windDir;
    }

    @JsonProperty("wind_dir")
    public void setWindDir(long windDir) {
        this.windDir = windDir;
    }

    @JsonProperty("rh")
    public long getRh() {
        return rh;
    }

    @JsonProperty("rh")
    public void setRh(long rh) {
        this.rh = rh;
    }

    @JsonProperty("wind_spd")
    public double getWindSpd() {
        return windSpd;
    }

    @JsonProperty("wind_spd")
    public void setWindSpd(double windSpd) {
        this.windSpd = windSpd;
    }

    @JsonProperty("pop")
    public long getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(long pop) {
        this.pop = pop;
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
    public double getWindGustSpd() {
        return windGustSpd;
    }

    @JsonProperty("wind_gust_spd")
    public void setWindGustSpd(double windGustSpd) {
        this.windGustSpd = windGustSpd;
    }

    @JsonProperty("slp")
    public double getSlp() {
        return slp;
    }

    @JsonProperty("slp")
    public void setSlp(double slp) {
        this.slp = slp;
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
    public long getCloudsMid() {
        return cloudsMid;
    }

    @JsonProperty("clouds_mid")
    public void setCloudsMid(long cloudsMid) {
        this.cloudsMid = cloudsMid;
    }

    @JsonProperty("clouds_low")
    public long getCloudsLow() {
        return cloudsLow;
    }

    @JsonProperty("clouds_low")
    public void setCloudsLow(long cloudsLow) {
        this.cloudsLow = cloudsLow;
    }

    @JsonProperty("pres")
    public double getPres() {
        return pres;
    }

    @JsonProperty("pres")
    public void setPres(double pres) {
        this.pres = pres;
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
    public double getDewpt() {
        return dewpt;
    }

    @JsonProperty("dewpt")
    public void setDewpt(double dewpt) {
        this.dewpt = dewpt;
    }

    @JsonProperty("snow")
    public long getSnow() {
        return snow;
    }

    @JsonProperty("snow")
    public void setSnow(long snow) {
        this.snow = snow;
    }

    @JsonProperty("uv")
    public double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(double uv) {
        this.uv = uv;
    }

    @JsonProperty("clouds_hi")
    public long getCloudsHi() {
        return cloudsHi;
    }

    @JsonProperty("clouds_hi")
    public void setCloudsHi(long cloudsHi) {
        this.cloudsHi = cloudsHi;
    }

    @JsonProperty("ozone")
    public double getOzone() {
        return ozone;
    }

    @JsonProperty("ozone")
    public void setOzone(double ozone) {
        this.ozone = ozone;
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
    public long getPrecip() {
        return precip;
    }

    @JsonProperty("precip")
    public void setPrecip(long precip) {
        this.precip = precip;
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
    public long getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(long ts) {
        this.ts = ts;
    }

    @JsonProperty("app_temp")
    public double getAppTemp() {
        return appTemp;
    }

    @JsonProperty("app_temp")
    public void setAppTemp(double appTemp) {
        this.appTemp = appTemp;
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
    public double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(double temp) {
        this.temp = temp;
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
    public long getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(long clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("vis")
    public double getVis() {
        return vis;
    }

    @JsonProperty("vis")
    public void setVis(double vis) {
        this.vis = vis;
    }

}
