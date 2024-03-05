package locations;

import Enums.Emotions;
import Objects.Character;

public class City extends AbstractLocation{
    public City(String name){
        super(name);
    }

    @Override
    public void interactLoc(Character character) {
        character.setCurrentEmotion(Emotions.NERVOUS);
    }
}
