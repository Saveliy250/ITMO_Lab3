package Weather;

import Objects.Character;

import java.util.Objects;

public abstract class AbstractWeather {
    private final String title;
    public AbstractWeather(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public abstract void interact(Character character);

    @Override
    public String toString() {
        return getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractWeather that = (AbstractWeather) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        int total = 37;
        total = total * 37 + title.hashCode();
        return total;
    }
}
