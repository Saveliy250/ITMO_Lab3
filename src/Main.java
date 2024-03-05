import Objects.Character;
import Objects.Boat;
import locations.City;
import locations.River;

public class Main {
    public static void main(String[] args) {
        Character gerasim = new Character("Gerasim");
        Character oldMan = new Character("Old man");
        Character mumu = new Character("Mumu");
        City city = new City("Moscow");
        River river = new River("River");
        Boat boat = new Boat("Boat");
        city.addCharacters(gerasim, mumu, oldMan);
        city.interactLoc(gerasim);
        mumu.setBoat(boat);
        city.exitLocation(mumu);
        river.addCharacters(mumu);
        river.interactLoc(mumu);
    }
}