package locations;

import Enums.Emotions;
import MyObjects.Character;

public class Village extends AbstractLocation{
    public Village(String name){
        super(name);
    }

    @Override
    public void interactLoc(Character character){
        System.out.println(character.getName() + " is chilling in " + name);
        character.setCurrentEmotion(Emotions.FREE);
    }
}
