package Objects;

import Enums.Conditions;
import Enums.Emotions;
import emotions.AbstractEmotion;
import locations.AbstractLocation;

public class Character {
    private final String name;
    private int stamina;
    private Conditions currentCondition;
    private Emotions currentEmotion = Emotions.CALM;
    private Boat boat;
    private AbstractLocation location;
    public Character(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }
    public Conditions getCurrentCondition(){
        return currentCondition;
    }

    public void setCurrentCondition(Conditions currentCondition){
        if (currentCondition != this.getCurrentCondition()) {
            this.currentCondition = currentCondition;
            System.out.println(getName() + " is now " + currentCondition.getTitle());
        }
    }

    public AbstractLocation getLocation() {
        return location;
    }

    public void setLocation(AbstractLocation location){
        if(location != this.getLocation() ) {
            this.location = location;
            if (location != null) {
                System.out.println(getName() + " is located in " + location.getName());
            }
        }
    }

    public Emotions getCurrentEmotion(){
        return currentEmotion;
    }

    public void setCurrentEmotion(Emotions currentEmotion){
        if (currentEmotion != this.getCurrentEmotion()) {
            this.currentEmotion = currentEmotion;
            System.out.println(getName() + " is now feeling " + currentEmotion.getTitle());
        }
    }

    public Boat getBoat(){
        return this.boat;
    }

    public void setBoat(Boat boat){
        if (this.getBoat() == null){
            this.boat = boat;
            System.out.println(name + " jumps in " + boat.getName());
        }
    }

}
