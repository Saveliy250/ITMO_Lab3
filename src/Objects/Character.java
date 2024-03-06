package Objects;

import Enums.Conditions;
import Enums.Emotions;
import emotions.AbstractEmotion;
import locations.AbstractLocation;
import locations.City;

public class Character {
    private final String name;
    private int stamina;
    private Conditions currentCondition;
    private Emotions currentEmotion = Emotions.CALM;
    private Boat boat;
    private AbstractLocation location;
    private AbstractLocation visitloc;
    private int bricksCount;
    private int speed;
    private Paddle paddle;
    public Character(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }
    public Conditions getCurrentCondition(){
        return currentCondition;
    }

    public void setCurrentCondition(Conditions currentCondition){
        if (currentCondition != this.getCurrentCondition()) {
            this.currentCondition = currentCondition;
            System.out.println(getName() + " is now " + currentCondition.getTitle());
        }
    }

    public AbstractLocation getLocation() {
        return location;
    }

    public void setLocation(AbstractLocation location){
        if(location != this.getLocation() ) {
            this.location = location;
            if (location != null) {
                System.out.println(getName() + " is located in " + location.getName());
            }
        }
    }
    public void setVisitLoc(AbstractLocation visitLoc){
        this.visitloc = visitLoc;
    }

    public Emotions getCurrentEmotion(){
        return currentEmotion;
    }

    public void setCurrentEmotion(Emotions currentEmotion){
        if (currentEmotion != this.getCurrentEmotion()) {
            this.currentEmotion = currentEmotion;
            System.out.println(getName() + " is now feeling " + currentEmotion.getTitle());
        }
    }

    public Boat getBoat(){
        return this.boat;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getBricksCount() {
        return bricksCount;
    }

    public void setBricksCount(int bricksCount) {
        this.bricksCount = bricksCount;
    }

    public void setBoat(Boat boat){
        if (this.getBoat() == null){
            this.boat = boat;
            System.out.println(name + " jumps in " + boat.getName());
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public void exitBoat(Boat boat){
        if (this.boat == boat){
            this.boat = null;
            System.out.println(name + " is got out of a " + boat.getName());
        }
    }
    public void walk(){
        if (speed < 50){
            System.out.println(name + " is walking slowly");
        } else {
            System.out.println(name + " is walking fast");
        }
        this.setStamina((int) (this.getStamina() - this.speed * 0.3));
    }
    public void stop(){
        this.setSpeed(0);
        System.out.println(name + " stopped");
    }
    public void think(String thought){
        System.out.println(name + " is thinking: " + thought);
    }

    public void takeBricks(City.Yard yard, int brickCount){
        if (this.visitloc == yard){
            if (yard.getBrickCount() >= brickCount) {
                yard.setBrickCount(yard.getBrickCount() - brickCount);
                this.setBricksCount(this.getBricksCount() + brickCount);
                System.out.println(name + " took " + brickCount + " bricks");
            } else {
                System.out.println(name + " didnt find needed amount of bricks");
                this.setCurrentEmotion(Emotions.SAD);
            }
        } else {
            System.out.println("There is no bricks in this place");
        }
    }
    public void see(Object o){
        System.out.println(name + " saw " + o.toString());
    }
    public void shout(String shout){
        System.out.println(name + " shouted: " + "'" + shout + "'");
    }
    public boolean row(Paddle paddle){
        this.setPaddle(paddle);
        if (this.stamina > 20){
            System.out.println(name + " is rowing");
            this.setStamina(this.getStamina() - 10);
            return true;
        } else {
            System.out.println(name + " cant row now and dropped paddle in water");
            this.paddle = null;
            return false;
        }
    }

}
