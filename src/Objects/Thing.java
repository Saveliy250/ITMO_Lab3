package Objects;

public class Thing extends Obj{

    final private String name;
    private String condition;

    public Thing(String name, String condition){
        super(name, condition);
        this.name = name;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return condition + " " + name;
    }
}
