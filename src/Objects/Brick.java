package Objects;

import Interfaces.Ropenable;

public class Brick implements Ropenable {
    private final String name;
    private Rope rope;
    public Brick(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Rope getRope() {
        return rope;
    }

    public void setRope(Rope rope) {
        if (this.getRope() != rope) {
            this.rope = rope;
        }
    }

    @Override
    public void rope(Rope rope){
        this.setRope(rope);
    }
}
