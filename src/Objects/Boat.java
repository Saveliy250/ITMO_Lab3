package Objects;

import Enums.Conditions;
import Objects.Character;
import locations.AbstractLocation;

public class Boat{

    private final String name;
    private Conditions currentCondition;
    private int speed;
    public Boat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Conditions getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(Conditions currentCondition) {
        if (this.currentCondition != currentCondition) {
            this.currentCondition = currentCondition;
            System.out.println(name + " becomes " + currentCondition.getTitle());
        }
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println(name + " is moving at speed: " + speed);
    }

    @Override
    public String toString(){
        return this.getName();
    }

}
