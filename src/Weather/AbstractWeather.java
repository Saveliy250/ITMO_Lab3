package Weather;

import Objects.Character;

public abstract class AbstractWeather {
    private final String title;
    public AbstractWeather(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public abstract void interact(Character character);

}
