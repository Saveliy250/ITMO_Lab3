package Objects;

import Enums.Conditions;
import Enums.Emotions;
import emotions.AbstractEmotion;
import locations.AbstractLocation;

public class Character {
    private final String name;
    private int stamina;
    private Conditions currentCondition;
    private Emotions currentEmotion;
    private AbstractLocation location;
    public Character(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }

    public void setCurrentCondition(Conditions currentCondition){
        this.currentCondition = currentCondition;
    }
    public void setLocation(AbstractLocation location){
        this.location = location;
    }

    public Emotions getCurrentEmotion(){
        return currentEmotion;
    }

    public void setCurrentEmotion(Emotions currentEmotion){
        if(this.currentEmotion != getCurrentEmotion()){
            this.currentEmotion = currentEmotion;
            System.out.println(getName() + "is now feeling" + currentEmotion.getTitle());
        }
    }
}
