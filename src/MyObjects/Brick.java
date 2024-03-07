package MyObjects;

import Interfaces.Ropenable;

import java.util.Objects;

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

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brick brick = (Brick) o;
        return Objects.equals(name, brick.name);
    }

    @Override
    public int hashCode() {
        int total = 37;
        total = total * 37 + name.hashCode();
        return total;
    }
}
