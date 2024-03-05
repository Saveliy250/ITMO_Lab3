package Enums;

public enum Conditions {
    TIRED ("Tired"),
    WET("Wet");




    private final  String title;
    Conditions(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
