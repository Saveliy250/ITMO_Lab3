import Enums.Action;
import Objects.Entity;
import Objects.Thing;

public class Main {
    public static void main(String[] args) {
        Entity e1 = new Entity("Льюис");
        Thing t1 = new Thing("лужа");
        e1.doSmth(Action.Fall, t1, "в");
        }
    }
