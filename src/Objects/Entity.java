package Objects;

import Enums.Action;

public class Entity extends Obj{

    final public String name;

    public Entity(String name){
        super(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void doSmth(Action act){
        if (act == Action.Fall){
            System.out.print(super.name + " упал");
        }

    }
    public void doSmth(Action act, Obj obj, String pr){
        doSmth(act);
        System.out.print(" " + pr + " " + obj);
    }

}
