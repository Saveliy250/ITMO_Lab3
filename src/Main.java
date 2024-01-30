import Enums.Action;
import Enums.Conditions;
import Objects.Entity;
import Objects.Thing;

public class Main {
    public static void main(String[] args) {
        Entity e1 = new Entity("Льюис", Conditions.TIRED.getTitle());
        Thing t1 = new Thing("лужа", Conditions.BIG.getTitle());
        e1.doSmth(Action.Fall, t1);
        }
    }
