package Enums;

import Weather.AbstractWeather;
import Weather.RainyWeather;
import Weather.WindyWeather;

public enum WeatherType {
    RAINY(new RainyWeather("Rainy")),
    WINDY(new WindyWeather("Windy"));

    public final AbstractWeather weather;
    WeatherType(AbstractWeather weather){
        this.weather = weather;
    }
    public AbstractWeather getWeather(){
        return weather;
    }
}
