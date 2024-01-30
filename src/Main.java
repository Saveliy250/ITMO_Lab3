import Enums.Action;
import Enums.Padezh;
import Objects.Entity;
import Objects.Thing;

public class Main {
    public static void main(String[] args) {
        Entity e1 = new Entity("Льюис", "Льюиса", "Льюису", "Льюиса", "Льюисом", "Льюисе");
        Thing t1 = new Thing("лужа", "лужи", "луже", "лужу", "лужей", "луже");
        e1.doSmth(Action.Fall, t1, "в", Padezh.VINITELNIY);
        }
    }
