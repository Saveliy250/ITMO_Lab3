package Objects;

import Enums.Action;
import Enums.Padezh;

public class Entity extends Obj{

    final public String name;
    final public String forRod;
    final public String forDat;
    final public String forVin;
    final public String forTvor;
    final public String forPred;

    public Entity(String name, String forRod, String forDat, String forVin, String forTvor, String forPred){
        super(name, forRod, forDat, forVin, forTvor, forPred);
        this.name = name;
        this.forRod = forRod;
        this.forDat = forDat;
        this.forVin = forVin;
        this.forTvor = forTvor;
        this.forPred = forPred;
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
    public void doSmth(Action act, Obj obj, String pr, Padezh padezh){
        doSmth(act);
        if (padezh == Padezh.IMENIT){
            System.out.print(" " + pr + " " + obj);
        }
        if (padezh == Padezh.RODITEL){
            System.out.print(" " + pr + " " + obj.forRod);
        }
        if (padezh == Padezh.DATELNIY){
            System.out.print(" " + pr + " " + obj.forDat);
        }
        if (padezh == Padezh.VINITELNIY){
            System.out.print(" " + pr + " " + obj.forVin);
        }
        if (padezh == Padezh.TVORITELNIY){
            System.out.print(" " + pr + " " + obj.forTvor);
        }
        if (padezh == Padezh.PREDLOZHNIY){
            System.out.print(" " + pr + " " + obj.forPred);
        }

    }

}
