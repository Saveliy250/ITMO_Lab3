package Objects;

import Objects.Character;
import locations.AbstractLocation;

public class Boat{

    private final String name;
    public Boat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return this.getName();
    }

}
