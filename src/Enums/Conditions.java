package Enums;

public enum Conditions {
    WET("Wet");

    private final  String title;
    Conditions(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
