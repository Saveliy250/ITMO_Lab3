package Weather;

import Enums.Conditions;
import Objects.Character;

public class RainyWeather extends AbstractWeather{
    public RainyWeather(){
        super("Rainy");
    }

    @Override
    public void interact(Character character){
        character.setCurrentCondition(Conditions.WET);
        System.out.println(character.getName() + "becomes WET");
    }
}
