package emotions;
import Interfaces.Emotinable;

public abstract class AbstractEmotion implements Emotinable {
    private final String title;
    private final int conscienceInfluence;

    public AbstractEmotion(String title, int conscienceInfluence){
        this.title = title;
        this.conscienceInfluence = conscienceInfluence;
    }

    public int getConscienceInfluence() {
        return conscienceInfluence;
    }
    @Override
    public String getTitle(){
        return title;
    }
}
