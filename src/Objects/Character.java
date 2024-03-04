package Objects;

import Enums.Conditions;
import emotions.AbstractEmotion;

public class Character {
    private final String name;
    private int stamina;
    private Conditions currentCondition;
    private AbstractEmotion currentEmotion;
    public Character(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }

    public void setCurrentCondition(Conditions currentCondition){
        this.currentCondition = currentCondition;
    }
}
