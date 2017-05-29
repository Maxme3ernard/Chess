package chess.time;

/**
 * Created by coni on 28/05/2017.
 */
public class Time {
    private final boolean whitePlayer;
    private int time;

    public Time(boolean whitePlayer, int startTime) {
        this.whitePlayer = whitePlayer;
        this.time = startTime;
    }

    public void decrease(){
        time--;
    }

    public int getTime(){
        return this.time;
    }
    public boolean isWhitePlayer(){
        return whitePlayer;
    }
}
