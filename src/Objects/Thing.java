package Objects;

public class Thing extends Obj{

    final public String name;

    public Thing(String name){
        super(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
