package MyObjects;

import Enums.Conditions;

import java.util.Objects;

public class Boat{

    private final String name;
    private Conditions currentCondition;
    private int speed;
    public Boat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Conditions getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(Conditions currentCondition) {
        if (this.currentCondition != currentCondition) {
            this.currentCondition = currentCondition;
            System.out.println(name + " becomes " + currentCondition.getTitle());
        }
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println(name + " is moving at speed: " + speed);
    }


    @Override
    public String toString(){
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return Objects.equals(name, boat.name) && currentCondition == boat.currentCondition;
    }

    @Override
    public int hashCode() {
        int total = 37;
        total = total * 37 + name.hashCode();
        total = total * 37 + currentCondition.hashCode();
        return total;
    }
}
