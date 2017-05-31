package chess.display.history;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by coni on 30/05/2017.
 */
public class ScrollPaneUI extends LayerUI<JScrollPane> {
    private boolean inside;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JLayer jLayer = (JLayer) c;
        jLayer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
    }

    @Override
    public void uninstallUI(JComponent c) {
        JLayer jLayer = (JLayer) c;
        jLayer.setLayerEventMask(0);
        super.uninstallUI(c);
    }

    @Override
    protected void processMouseEvent(MouseEvent e, JLayer l) {
        if (e.getID() == MouseEvent.MOUSE_ENTERED) inside = true;
        else if (e.getID() == MouseEvent.MOUSE_EXITED) inside = false;
        l.repaint();
    }

    public boolean isInside() {
        return inside;
    }
}
