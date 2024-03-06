package locations;

import Objects.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractLocation {
    protected String name;
    private final List<Character> characters = new ArrayList<>();
    public AbstractLocation(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract void interactLoc(Character character);
    public Character[] getCharacters(){
        Character[] characters = new Character[this.characters.size()];
        return this.characters.toArray(characters);
    }
    public void addCharacters(Character... characters){
        this.characters.addAll(Arrays.asList(characters));
        for(Character character: characters){
            character.setLocation(this);
        }
    }
    public void removeCharacters(Character... characters){
        for (Character character: characters){
            character.setLocation(null);
            this.characters.remove(character);

        }
    }
    public void exitLocation(Character character){
        removeCharacters(character);
        System.out.println(character.getName() + " leaves " + getName());
    }
    @Override
    public String toString(){
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractLocation that = (AbstractLocation) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int total = 37;
        total = total * 37 + name.hashCode();
        return total;
    }
}
