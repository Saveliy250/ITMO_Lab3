package Enums;

public enum Conditions {
    TIRED ("усталый"),
    BIG ("большая"),
    WET("мокрый");




    private String title;
    Conditions(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
