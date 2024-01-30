package Objects;

public class Thing extends Obj{

    final public String name;
    final public String forRod;
    final public String forDat;
    final public String forVin;
    final public String forTvor;
    final public String forPred;

    public Thing(String name, String forRod, String forDat, String forVin, String forTvor, String forPred){
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
}
