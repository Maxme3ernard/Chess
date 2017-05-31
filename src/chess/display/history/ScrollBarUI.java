package chess.display.history;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Created by coni on 30/05/2017.
 */
public class ScrollBarUI extends BasicScrollBarUI {
    private final ScrollPaneUI pane;

    public ScrollBarUI(ScrollPaneUI pane) {
        this.pane = pane;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        if (pane.isInside()) {
            g.setColor(new Color(111, 111, 111, 150));
            g.fillRoundRect(trackBounds.x + trackBounds.width / 4, trackBounds.y, trackBounds.width / 2, trackBounds.height, 10,10);
        }
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(Color.GRAY.darker());
        double w = (double)thumbBounds.width / 3;
        g.fillRoundRect((int) (thumbBounds.x + w), thumbBounds.y + 3, (int)w, thumbBounds.height - 6, 3,3);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton jbutton = new JButton();
        jbutton.setPreferredSize(new Dimension(0, 0));
        jbutton.setMinimumSize(new Dimension(0, 0));
        jbutton.setMaximumSize(new Dimension(0, 0));
        return jbutton;
    }
}
