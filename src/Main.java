import Enums.Conditions;
import Enums.Emotions;
import Objects.*;
import Objects.Character;
import locations.City;
import locations.River;
import locations.Village;

public class Main {
    public static void main(String[] args) {
        Character gerasim = new Character("Gerasim");
        Character oldMan = new Character("Old man");
        Character mumu = new Character("Mumu");
        City city = new City("Moscow");
        River river = new River("River");
        Village smallVillage = new Village("Small village");
        Village mainVillage = new Village("Main Village");
        Boat boat1 = new Boat("Boat1");
        Boat boat2 = new Boat("Boat2");
        City.Yard yard = new City.Yard("Yard");
        Paddle paddle = new Paddle("Paddle");
        Brick brick = new Brick("Brick");
        Rope rope = new Rope("Rope");


        gerasim.setStamina(100);
        mumu.setStamina(100);
        city.addCharacters(gerasim, mumu, oldMan);
        gerasim.setSpeed(20);
        mumu.setSpeed(20);
        gerasim.walk();
        mumu.walk();
        gerasim.stop();
        mumu.stop();
        gerasim.think("i need a brick");
        gerasim.setSpeed(60);
        mumu.setSpeed(60);
        gerasim.walk();
        mumu.walk();
        yard.visit(gerasim);
        yard.setBrickCount(10);
        gerasim.takeBricks(yard, 1);
        gerasim.walk();
        mumu.walk();
        gerasim.see(boat1);
        gerasim.see(boat2);
        gerasim.setCurrentEmotion(Emotions.HAPPY);
        mumu.setCurrentEmotion(Emotions.NERVOUS);
        gerasim.setBoat(boat2);
        mumu.setBoat(boat2);
        oldMan.setSpeed(5);
        oldMan.walk();
        oldMan.stop();
        oldMan.shout("HEY!");
        oldMan.setCurrentEmotion(Emotions.ANGRY);
        if (gerasim.row(boat2, paddle)) {
            city.exitLocation(gerasim);
            city.exitLocation(mumu);
            oldMan.think("What a coward!");
            oldMan.think("There is nothing i can do");
            oldMan.setCurrentEmotion(Emotions.CALM);
            System.out.println("\n");
            river.addCharacters(gerasim, mumu);
            gerasim.row(boat2, paddle);
            gerasim.see(smallVillage);
            gerasim.setCurrentEmotion(Emotions.SAD);
            gerasim.row(boat2, paddle);
            gerasim.stopRowing(boat2);
            gerasim.setCurrentCondition(Conditions.WET);
            gerasim.tie(brick, rope, mumu);
            if (mumu.getRope() != null){
                mumu.exitBoat(boat2);
                river.interactLoc(mumu);
                mumu.dying();
                gerasim.setCurrentEmotion(Emotions.DEPRESSED);
                if (gerasim.row(boat2, paddle)){
                    river.exitLocation(gerasim);
                    mainVillage.addCharacters(gerasim);
                    gerasim.exitBoat(boat2);
                    mainVillage.interactLoc(gerasim);
                    System.out.println("\nDefault ending");
                } else {
                    river.exitLocation(gerasim);
                    city.addCharacters(gerasim);
                    gerasim.exitBoat(boat2);
                    oldMan.shout("You'll work for this paddle!");
                    gerasim.setCurrentEmotion(Emotions.SCARED);
                    System.out.println("\nAlternative ending");
                }
            } else {
                gerasim.think("Wait, i love this dog!");
                gerasim.setCurrentEmotion(Emotions.HAPPY);
                if (gerasim.row(boat2, paddle)){
                    river.exitLocation(gerasim);
                    river.exitLocation(mumu);
                    mainVillage.addCharacters(gerasim, mumu);
                    gerasim.exitBoat(boat2);
                    mumu.exitBoat(boat2);
                    mainVillage.interactLoc(gerasim);
                    mainVillage.interactLoc(mumu);
                    System.out.println("\nGood ending");
                } else {
                    river.exitLocation(gerasim);
                    river.exitLocation(mumu);
                    city.addCharacters(gerasim, mumu);
                    gerasim.exitBoat(boat2);
                    mumu.exitBoat(boat2);
                    oldMan.shout("You'll work for this paddle!");
                    gerasim.setCurrentEmotion(Emotions.SCARED);
                    mumu.setCurrentEmotion(Emotions.HAPPY);
                    mumu.think("I love Gerasim!");
                    System.out.println("\nAlternative good ending");
                }

            }
        } else {
            gerasim.exitBoat(boat2);
            mumu.exitBoat(boat2);
            oldMan.shout("You'll work for this paddle!");
            gerasim.setCurrentEmotion(Emotions.SCARED);
            mumu.setCurrentEmotion(Emotions.CALM);
            System.out.println("\nAlternative ending");
        }

    }
}