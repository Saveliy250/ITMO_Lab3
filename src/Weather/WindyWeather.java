package Weather;

import MyObjects.Boat;
import MyObjects.Character;

public class WindyWeather extends AbstractWeather {
    public WindyWeather(String title){
        super(title);
    }
    @Override
    public void interact(Character character, Boat boat){
        System.out.println("It became windy");
        boat.setSpeed(boat.getSpeed() - 10);
        System.out.println(boat.getName() + " is moving slower cause of wind");
    }
}
