package MyObjects;

import java.util.Objects;

public class Rope {
    private final String name;
    public Rope(String name){
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
        Rope rope = (Rope) o;
        return Objects.equals(name, rope.name);
    }

    @Override
    public int hashCode() {
        int total = 37;
        total = total * 37 + name.hashCode();
        return total;
    }
}
