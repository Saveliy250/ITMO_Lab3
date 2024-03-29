package Enums;

public enum Emotions {
    NERVOUS("Nervous"),
    RELAXED("Relaxed"),
    SCARED("Scared"),
    CALM("Calm"),
    SAD("Sad"),
    ANGRY("Angry"),
    HAPPY("Happy"),
    DEPRESSED("Depressed"),
    FREE("Free"),
    SURPRISED("Surprised");

    private final String title;
    Emotions(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
