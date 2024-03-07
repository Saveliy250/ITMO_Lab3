package locations;

import Enums.Emotions;
import MyObjects.Character;

public class City extends AbstractLocation{
    public City(String name){
        super(name);
    }

    @Override
    public void interactLoc(Character character) {
        if (character.getLocation() == this) {
            character.setCurrentEmotion(Emotions.NERVOUS);
        }
    }
    public static class Yard extends City{
        private int brickCount;

        public Yard(String name){
            super(name);
        }
        public int getBrickCount() {
            return brickCount;
        }

        public void setBrickCount(int brickCount) {
            this.brickCount = brickCount;
        }
        public void visit(Character character){
            character.setVisitLoc(this);
            System.out.println(character.getName() + " visited " + name);
        }
    }
}
