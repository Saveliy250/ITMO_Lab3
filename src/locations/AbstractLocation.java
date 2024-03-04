package locations;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLocation {
    private String name;
    private List<Character> characters = new ArrayList<>();
    public AbstractLocation(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
