package Weather;

import Enums.Conditions;
import MyObjects.Boat;
import MyObjects.Character;

public class RainyWeather extends AbstractWeather{
    public RainyWeather(String title){
        super(title);
    }

    @Override
    public void interact(Character character, Boat boat){
        System.out.println("It started to rain");
        character.setCurrentCondition(Conditions.WET);
        boat.setCurrentCondition(Conditions.WET);
        System.out.println(character.getName() + "becomes WET");
    }
}
