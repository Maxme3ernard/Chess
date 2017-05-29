package chess.time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by coni on 28/05/2017.
 */
public class TimeCounter extends Observable implements ActionListener {
    private final Time white;
    private final Time black;
    private Time activeTime;
    private boolean first = true;

    public TimeCounter(int playTime) {
        white = new Time(true, playTime);
        black = new Time(false, playTime);
        activeTime = white;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (first){
            first = false;
            setChanged();
            notifyObservers(white);
            setChanged();
            notifyObservers(black);
            return;
        }
        activeTime.decrease();
        setChanged();
        notifyObservers(activeTime);
    }
}
