package Enums;

public enum Emotions {
    NERVOUS("Nervous"),
    RELAXED("Relaxed"),
    SCARED("Scared"),
    CALM("Calm"),
    SAD("Sad"),
    HAPPY("Happy");

    private final String title;
    Emotions(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
