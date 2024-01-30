package Objects;

import Enums.Action;
import Interfaces.Property;

public class Entity extends Obj implements Property {

    final private String name;
    private String condition;

    public Entity(String name, String condition){
        super(name, condition);
        this.name = name;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return condition + name;
    }

    public void doSmth(Action act){
        if (act == Action.Fall){
            System.out.print(super.condition + " " + super.name + " упал");
        }

    }
    public void doSmth(Action act, Obj obj){
        doSmth(act);
        System.out.print(" " + obj);
    }
    @Override
    public void propertyes(String property){
        super.name = " " + property + this.name;

    }

}
