package Objects;

import Enums.Conditions;
import Enums.Emotions;
import Interfaces.Ropenable;
import locations.AbstractLocation;
import locations.City;

import java.util.Objects;

public class Character implements Ropenable {
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
    private Rope rope;
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
        System.out.println(name + " saw " + o);
    }
    public void shout(String shout){
        System.out.println(name + " shouted: " + "'" + shout + "'");
    }
    public boolean row(Boat boat, Paddle paddle){
        this.setPaddle(paddle);
        if (this.stamina > 20){
            System.out.println(name + " is rowing");
            boat.setSpeed((int) (this.getStamina() * 1.5));
            this.setStamina(this.getStamina() - 10);
            return true;
        } else {
            System.out.println(name + " cant row now and dropped paddle in water");
            this.paddle = null;
            return false;
        }
    }
    public void stopRowing(Boat boat){
        this.paddle = null;
        System.out.println(name + " stopped rowing");
        boat.setSpeed(-5);
    }
    public void tie(Brick brick, Rope rope, Character character){
        if (this.bricksCount > 0) {
            if (this.getCurrentCondition() != Conditions.WET) {
                character.rope(rope);
                brick.rope(rope);
                System.out.println(name + " tied " + brick.getName() + " with " + character.getName());
                character.setCurrentEmotion(Emotions.RELAXED);
            } else {
                if (Math.random()*1 <= 0.4){
                    System.out.println(character.getName() + " slips out of the loop");
                    character.setCurrentEmotion(Emotions.SURPRISED);
                } else {
                    character.rope(rope);
                    brick.rope(rope);
                    System.out.println(name + " tied " + brick.getName() + " with " + character.getName());
                    character.setCurrentEmotion(Emotions.RELAXED);
                }
            }
        } else {
            System.out.println("No bricks to tie with");
            character.setCurrentEmotion(Emotions.HAPPY);
        }
    }
    public void dying(){
        for (int i = this.getStamina(); i > 0; i = i - 15){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored){
            }
            this.setStamina(i);
            System.out.println(". . .");
        }
        System.out.println(name + " is dead(");

    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return stamina == character.stamina && speed == character.speed && Objects.equals(name, character.name) && currentCondition == character.currentCondition && currentEmotion == character.currentEmotion;
    }

    @Override
    public int hashCode() {
        int total = 37;
        total = total * 37 + name.hashCode();
        total = total * 37 + stamina;
        total = total * 37 + currentEmotion.hashCode();
        total = total * 37 + currentCondition.hashCode();
        total = total * 37 + speed;
        return total;
    }
}
