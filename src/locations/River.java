package locations;

import Enums.Conditions;
import Enums.Emotions;
import MyObjects.Character;

public class River extends AbstractLocation{
    public River(String name){
        super(name);
    }

    @Override
    public void interactLoc(Character character) {
        if (character.getLocation() == this){
            if (character.getBoat() == null) {
                character.setCurrentEmotion(Emotions.SAD);
                character.setCurrentCondition(Conditions.WET);
            }
            else {
                character.setCurrentEmotion(Emotions.RELAXED);
            }
        }
    }
}
