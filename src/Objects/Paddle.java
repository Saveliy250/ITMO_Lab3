package Objects;

import java.util.Objects;

public class Paddle{
    private final String name;
    public Paddle(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paddle paddle = (Paddle) o;
        return Objects.equals(name, paddle.name);
    }

    @Override
    public int hashCode() {
        int total = 37;
        total = total * 37 + name.hashCode();
        return total;
    }
}
