import Enums.Conditions;
import Enums.Emotions;
import Enums.WeatherType;
import Interfaces.Thinkable;
import MyObjects.*;
import MyObjects.Character;
import exceptions.BoatFailException;
import exceptions.NoBrickException;
import exceptions.NoStaminaException;
import locations.City;
import locations.River;
import locations.Village;

import java.util.Arrays;

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
        WeatherType rain = WeatherType.RAINY;
        WeatherType wind = WeatherType.WINDY;


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
        try {
            gerasim.takeBricks(yard, 1);
        } catch (NoBrickException e){
            System.out.println(e.getMessage());
        }
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
        Thinkable storyTeller = new Thinkable() {
            public final String name = "Turgenev";
            @Override
            public void think(String thought) {
                System.out.println(name + " thinks: " + choiceThought());
            }
            public String choiceThought(){
                return switch ((int) (Math.random() * 2)){
                    case 0 -> "Interesting, what happend next?";
                    case 1 -> "I would love a story like that.";
                    case 2 -> "I would like to understand the feelings of the characters.";
                    default -> null;
                };
            }
        };
        try{
            gerasim.row(paddle);
        } catch(BoatFailException | NoStaminaException e){
            System.out.println(e.getMessage());
        }
        if(gerasim.isRowing()){
            city.exitLocation(gerasim);
            city.exitLocation(mumu);
            oldMan.think("What a coward!");
            oldMan.think("There is nothing i can do");
            oldMan.setCurrentEmotion(Emotions.CALM);
            System.out.println("\n");
            river.addCharacters(gerasim, mumu);
            rain.getWeather().interact(gerasim, boat2);
            try{
                gerasim.row(paddle);
                gerasim.see(smallVillage);
                gerasim.setCurrentEmotion(Emotions.SAD);
                wind.getWeather().interact(gerasim, boat2);
                gerasim.row(paddle);
            } catch(BoatFailException | NoStaminaException e){
                System.out.println(e.getMessage());
            }
            try{
                gerasim.stopRowing();
            } catch(BoatFailException e){
                System.out.println(e.getMessage());
            }
            gerasim.tie(brick, rope, mumu);
            if (mumu.getRope() != null){
                try {
                    mumu.exitBoat();
                } catch (BoatFailException e) {
                    System.out.println(e.getMessage());
                }
                river.interactLoc(mumu);
                mumu.dying();
                gerasim.setCurrentEmotion(Emotions.DEPRESSED);
                try{
                    gerasim.row(paddle);
                } catch(BoatFailException | NoStaminaException e){
                    System.out.println(e.getMessage());
                }
                if (gerasim.isRowing()){
                    river.exitLocation(gerasim);
                    mainVillage.addCharacters(gerasim);
                    try {
                        gerasim.exitBoat();
                    } catch (BoatFailException e) {
                        System.out.println(e.getMessage());
                    }
                    mainVillage.interactLoc(gerasim);
                    System.out.println("\nDefault ending");
                    storyTeller.think("");
                } else {
                    river.exitLocation(gerasim);
                    city.addCharacters(gerasim);
                    try {
                        gerasim.exitBoat();
                    } catch (BoatFailException e) {
                        System.out.println(e.getMessage());
                    }
                    oldMan.shout("You'll work for this paddle!");
                    gerasim.setCurrentEmotion(Emotions.SCARED);
                    System.out.println("\nAlternative ending");
                    storyTeller.think("");
                }
            } else {
                gerasim.think("Wait, i love this dog!");
                gerasim.setCurrentEmotion(Emotions.HAPPY);
                try{
                    gerasim.row(paddle);
                } catch(BoatFailException | NoStaminaException e){
                    System.out.println(e.getMessage());
                }
                if (gerasim.isRowing()){
                    river.exitLocation(gerasim);
                    river.exitLocation(mumu);
                    mainVillage.addCharacters(gerasim, mumu);
                    try {
                        gerasim.exitBoat();
                        mumu.exitBoat();
                    } catch (BoatFailException e) {
                        System.out.println(e.getMessage());
                    }
                    mainVillage.interactLoc(gerasim);
                    mainVillage.interactLoc(mumu);
                    System.out.println("\nGood ending");
                    storyTeller.think("");
                } else {
                    river.exitLocation(gerasim);
                    river.exitLocation(mumu);
                    city.addCharacters(gerasim, mumu);
                    try {
                        gerasim.exitBoat();
                        mumu.exitBoat();
                    } catch (BoatFailException e) {
                        System.out.println(e.getMessage());
                    }
                    oldMan.shout("You'll work for this paddle!");
                    gerasim.setCurrentEmotion(Emotions.SCARED);
                    mumu.setCurrentEmotion(Emotions.HAPPY);
                    mumu.think("I love Gerasim!");
                    System.out.println("\nAlternative good ending");
                    storyTeller.think("");
                }

            }
        } else {
            try {
                mumu.exitBoat();
                gerasim.exitBoat();
            } catch (BoatFailException e) {
                System.out.println(e.getMessage());
            }
            oldMan.shout("You'll work for this paddle!");
            gerasim.setCurrentEmotion(Emotions.SCARED);
            mumu.setCurrentEmotion(Emotions.CALM);
            System.out.println("\nAlternative ending");
            storyTeller.think("");
        }

    }
}