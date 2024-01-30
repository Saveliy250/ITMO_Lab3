package Objects;

import java.lang.reflect.Array;

public abstract class Obj {
    protected String name;
    protected String forRod;
    protected String forDat;
    protected String forVin;
    protected String forTvor;
    protected String forPred;
    public Obj(String name, String forRod, String forDat, String forVin, String forTvor, String forPred){
        this.name = name;
        this.forRod = forRod;
        this.forDat = forDat;
        this.forVin = forVin;
        this.forTvor = forTvor;
        this.forPred = forPred;
    }


}
