import Enums.Emotions;
import Objects.Character;
import Objects.Boat;
import Objects.Paddle;
import locations.City;
import locations.River;

public class Main {
    public static void main(String[] args) {
        Character gerasim = new Character("Gerasim");
        Character oldMan = new Character("Old man");
        Character mumu = new Character("Mumu");
        City city = new City("Moscow");
        River river = new River("River");
        Boat boat1 = new Boat("Boat1");
        Boat boat2 = new Boat("Boat2");
        City.Yard yard = new City.Yard("Yard");
        Paddle paddle = new Paddle("Paddle");


        gerasim.setStamina(100);
        city.addCharacters(gerasim, mumu, oldMan);
        gerasim.setSpeed(20);
        mumu.setSpeed(20);
        gerasim.walk();
        mumu.walk();
        gerasim.stop();
        mumu.stop();
        gerasim.think("i need a brick");
        gerasim.setSpeed(70);
        mumu.setSpeed(70);
        gerasim.walk();
        mumu.walk();
        yard.visit(gerasim);
        yard.setBrickCount(10);
        gerasim.takeBricks(yard, 2);
        gerasim.walk();
        mumu.walk();
        gerasim.see(boat1);
        gerasim.see(boat2);
        gerasim.setCurrentEmotion(Emotions.HAPPY);
        gerasim.setBoat(boat2);
        mumu.setBoat(boat2);
        oldMan.setSpeed(5);
        oldMan.walk();
        oldMan.stop();
        oldMan.shout("HEY!");
        oldMan.setCurrentEmotion(Emotions.ANGRY);
        gerasim.row(paddle);
        city.exitLocation(gerasim);
        city.exitLocation(mumu);
        oldMan.think("What a coward!");
        oldMan.think("There is nothing i can do");
        oldMan.setCurrentEmotion(Emotions.CALM);


    }
}